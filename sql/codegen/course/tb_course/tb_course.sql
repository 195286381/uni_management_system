drop table if exists tb_course;
create table tb_course (
                            id bigint(20) not null auto_increment comment"用户id",
                            username varchar(255) not null comment"用户名",
                            create_by        varchar(64)     default ''                 comment '创建者',
                            create_time      datetime                                   comment '创建时间',
                            update_by        varchar(64)     default ''                 comment '更新者',
                            update_time      datetime                                   comment '更新时间',
                            remark           varchar(500)    default null               comment '备注',
                            primary key (id)
) engine=innodb auto_increment=100 comment = '课程表';

# alter table tb_course modify id auto_increment;