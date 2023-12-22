package com.example.service.impl;

import com.example.dao.AdmissionMapper;
import com.example.pojo.Admission;
import com.example.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    private final AdmissionMapper admissionMapper;

    @Autowired
    public AdmissionServiceImpl(AdmissionMapper admissionMapper) {
        this.admissionMapper = admissionMapper;
    }

    // 插入录取信息
    @Override
    public void addAdmission(Admission admission) {
        admissionMapper.insertAdmission(admission);
    }

    // 根据录取记录编号查询录取信息
    @Override
    public Admission getAdmissionById(int admissionId) {
        return admissionMapper.selectAdmissionById(admissionId);
    }

    // 更新录取信息
    @Override
    public void updateAdmission(Admission admission) {
        admissionMapper.updateAdmission(admission);
    }

    // 删除录取信息
    @Override
    public void deleteAdmission(int admissionId) {
        admissionMapper.deleteAdmission(admissionId);
    }

    // 查询所有录取信息
    @Override
    public List<Admission> getAllAdmissions() {
        return admissionMapper.getAllAdmissions();
    }

    // 其他自定义查询方法的实现...
}
