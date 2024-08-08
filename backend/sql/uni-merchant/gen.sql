CREATE TABLE tb_region (
                           id INT AUTO_INCREMENT PRIMARY KEY COMMENT '区域ID',
                           region_name VARCHAR(255) NOT NULL COMMENT '区域名称',
                           create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           create_by VARCHAR(255) COMMENT '创建人',
                           update_by VARCHAR(255) COMMENT '更新人',
                           remark TEXT COMMENT '备注'
) comment '区域表';


CREATE TABLE tb_partner (
                            id INT AUTO_INCREMENT PRIMARY KEY COMMENT '合作商ID',
                            partner_name VARCHAR(255) NOT NULL COMMENT '合作商名称',
                            contact_person VARCHAR(255) COMMENT '联系人',
                            contact_number VARCHAR(20) COMMENT '联系电话',
                            revenue_share INT COMMENT '分成比例',
                            account VARCHAR(255) COMMENT '账号',
                            password VARCHAR(255) COMMENT '密码',
                            create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            create_by VARCHAR(255) COMMENT '创建人',
                            update_by VARCHAR(255) COMMENT '更新人',
                            remark TEXT COMMENT '备注'
) comment '合作商表';

CREATE TABLE tb_node (
                         id INT AUTO_INCREMENT PRIMARY KEY COMMENT '点位ID',
                         node_name VARCHAR(255) NOT NULL COMMENT '点位名称',
                         address TEXT COMMENT '详细地址',
                         business_area_type INT COMMENT '商圈类型',
                         region_id INT COMMENT '所属区域ID',
                         partner_id INT COMMENT '所属合作商ID',
                         create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         create_by VARCHAR(255) COMMENT '创建人',
                         update_by VARCHAR(255) COMMENT '更新人',
                         remark TEXT COMMENT '备注',
                         FOREIGN KEY (region_id) REFERENCES tb_region(id),
                         FOREIGN KEY (partner_id) REFERENCES tb_partner(id)
) comment '点位表';

INSERT INTO tb_region (region_name, create_by, update_by)
VALUES ('朝阳区', 'admin', 'admin'),
       ('海淀区', 'admin', 'admin'),
       ('东城区', 'admin', 'admin');

INSERT INTO tb_partner (partner_name, contact_person, contact_number, revenue_share, account, password, create_by, update_by)
VALUES ('北京科技公司', '张三', '13800138000', 60, 'beijingtech', 'password123', 'admin', 'admin'),
       ('北京文化发展', '李四', '13900139000', 55, 'bjculture', 'securepass', 'admin', 'admin');

INSERT INTO tb_node (node_name, address, business_area_type, region_id, partner_id, create_by, update_by)
VALUES ('国贸商业中心', '北京市朝阳区建国门外大街1号', 1, 1, 1, 'admin', 'admin'),
       ('中关村科技园', '北京市海淀区中关村大街1号', 2, 2, 2, 'admin', 'admin'),
       ('王府井商业街', '北京市东城区王府井大街', 3, 3, 1, 'admin', 'admin');