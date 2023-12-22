package com.example.service;

import com.example.pojo.Admission;

import java.util.List;

public interface AdmissionService {

    // 插入录取信息
    void addAdmission(Admission admission);

    // 根据录取记录编号查询录取信息
    Admission getAdmissionById(int admissionId);

    // 更新录取信息
    void updateAdmission(Admission admission);

    // 删除录取信息
    void deleteAdmission(int admissionId);

    // 查询所有录取信息
    List<Admission> getAllAdmissions();

    // 其他自定义查询方法...
}
