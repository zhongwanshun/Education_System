package com.bjtu.edu.service.Impl;

import com.bjtu.edu.dao.HomeworkDao;
import com.bjtu.edu.dto.FileHolder;
import com.bjtu.edu.dto.HomeworkExecution;
import com.bjtu.edu.entity.Homework;
import com.bjtu.edu.enums.HomeworkStateEnum;
import com.bjtu.edu.exception.HomeworkOperationException;
import com.bjtu.edu.service.HomeworkService;
import com.bjtu.edu.util.FileUtil;
import com.bjtu.edu.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @project: mvc
 * @description: HomeWorkService实现类
 * @author: wanShun
 * @create: 2022/11/30
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;


    @Override
    public List<Homework> getHomeworkList() {
        return homeworkDao.queryHomework();
    }


    @Override
    public Homework getHomeworkById(long homeworkId) {
        return homeworkDao.queryHomeworkById(homeworkId);
    }


    @Override
    public List<Homework> getHomeworkByCourseId(long courseId) {
        return homeworkDao.queryHomeworkByCourseId(courseId);
    }


    @Override
    public List<Homework> getHomeworkByTeacherId(long teacherId) {
        return homeworkDao.queryHomeworkByTeacherId(teacherId);
    }


    @Override
    public List<Homework> getHomeworkByStudentId(long studentId) {
        return homeworkDao.queryHomeworkByStudentId(studentId);
    }


    @Override
    public HomeworkExecution addHomework(Homework homework, FileHolder fileHolder) {
        //空值判断
        if (homework == null ){
            return new HomeworkExecution(HomeworkStateEnum.EMPTY);
        }
        try {
            //设置创建时间
            homework.setCreateTime(new Date());
            //添加作业信息
            int effectedNum = homeworkDao.addHomework(homework);
            //判断是否添加成功
            if (effectedNum <= 0){
                throw new HomeworkOperationException("添加作业信息失败");
            } else {
                //如果条件成功，判断是否需要处理文件流
                if (fileHolder != null){
                    if (fileHolder.getFile() != null){
                        //存储文件
                        try {
                            //生成文件
                            addHomeworkFile(homework,fileHolder);
                        }catch (Exception e){
                            throw new HomeworkOperationException("addHomeworkFile error:" + e.getMessage());
                        }
                        //更新作业的文件地址
                        effectedNum = homeworkDao.modifyHomework(homework);
                        //判断是否更新成功
                        if (effectedNum <= 0){
                            throw new HomeworkOperationException("更新文件地址失败");
                        }
                    }
                }
            }
        }catch (Exception e){
            throw new HomeworkOperationException("addHomework error:" + e.getMessage());
        }
        return new HomeworkExecution(HomeworkStateEnum.SUCCESS,homework);
    }


    @Override
    public HomeworkExecution modifyHomework(Homework homework, FileHolder fileHolder) {
        //空值判断
        if (homework == null || homework.getHomeworkId() == null){
            return new HomeworkExecution(HomeworkStateEnum.EMPTY);
        }
        try {
            //1.判断是否需要处理文件
            if (fileHolder != null){
                if (fileHolder.getFile() != null && fileHolder.getFileName() != null && !"".equals(fileHolder.getFileName())){
                    Homework tempHomework = homeworkDao.queryHomeworkById(homework.getHomeworkId());
                    //如果原路径下有文件存在，则删除原路径下的所有文件
                    if (tempHomework.getHomeworkFile() != null){
                        FileUtil.deleteFileOrPath(tempHomework.getHomeworkFile());
                    }
                    //生成新的作业文件
                    addHomeworkFile(homework, fileHolder);
                }
            }

            //2.修改作业信息
            //设置更新时间
            homework.setLastEditTime(new Date());
            //修改作业信息
            int effectedNum = homeworkDao.modifyHomework(homework);
            //判断是否修改成功
            if (effectedNum <= 0){
                return new HomeworkExecution(HomeworkStateEnum.INNER_ERROR);
            }else {
                homework = homeworkDao.queryHomeworkById(homework.getHomeworkId());
                return new HomeworkExecution(HomeworkStateEnum.SUCCESS,homework);
            }
        }catch (Exception e){
            throw new HomeworkOperationException("modifyHomeworkError:" + e.getMessage());
        }
    }


    @Override
    public HomeworkExecution deleteHomework(long homeworkId) {
        // 根据homeworkId获取原来的文件并删除
        Homework homework = homeworkDao.queryHomeworkById(homeworkId);
        if (homework.getHomeworkFile() != null){
            FileUtil.deleteFileOrPath(homework.getHomeworkFile());
        }

        //删除该作业信息
        try {
            int effectedNum = homeworkDao.deleteHomework(homeworkId);
            //判断是否删除成功
            if (effectedNum <= 0) {
                throw new HomeworkOperationException("作业信息删除失败");
            } else {
                return new HomeworkExecution(HomeworkStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new HomeworkOperationException("deleteHomework error:" + e.getMessage());
        }
    }

    private void addHomeworkFile(Homework homework, FileHolder fileHolder) {
        //获取homework文件目录的相对值路径
        String dest = PathUtil.getHomeworkFilePath(homework.getHomeworkId());
        //在相应目录下生成上传的文件，并返回新生成的文件路径
        String homeworkFileAddr = FileUtil.generateNewFile(fileHolder,dest);
        //将新生成的文件路径赋值到homework的字段中
        homework.setHomeworkFile(homeworkFileAddr);
    }
}
