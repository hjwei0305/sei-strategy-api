package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 项目与文件关联表(StrategyPlansFiles)实体类
 *
 * @author sei
 * @since 2023-05-09 15:12:42
 */
@Entity
@Table(name = "strategy_plans_files")
@DynamicInsert
@DynamicUpdate
public class StrategyPlansFiles extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 889506561215027049L;
    /**
     * 项目id
     */
    @Column(name = "project_id")
    private String projectId;
    /**
     * 文件id
     */
    @Column(name = "file_id")
    private String fileId;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}
