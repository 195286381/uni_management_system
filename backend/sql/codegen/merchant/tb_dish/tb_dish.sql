drop table if exists tb_dish;
create table tb_dish (
                         id bigint auto_increment comment '菜品id',
                         name varchar(32) not null comment '菜品名称',
                         price decimal(10, 2) not null comment '菜品单价',
                         image varchar(255) not null comment '图片',
                         decription varchar(255) default '' comment '描述',
                         status int not null comment '状态',
                         create_by        varchar(64)     default ''                 comment '创建者',
                         create_time      datetime                                   comment '创建时间',
                         update_by        varchar(64)     default ''                 comment '更新者',
                         update_time      datetime                                   comment '更新时间',
                         remark           varchar(500)    default null               comment '备注',
                         primary key (id)
) engine=innodb comment '菜品表';


drop table if exists tb_dish_flavor;
create table tb_dish_flavor (
                                id               bigint          auto_increment             comment '菜品口味id',
                                dish_id          bigint                                     comment '菜品id',
                                name             varchar(32)     not null                   comment '口味名称',
                                value            varchar(255)    not null                   comment '口味数据',
                                create_by        varchar(64)     default ''                 comment '创建者',
                                create_time      datetime                                   comment '创建时间',
                                update_by        varchar(64)     default ''                 comment '更新者',
                                update_time      datetime                                   comment '更新时间',
                                remark           varchar(500)    default null               comment '备注',
                                primary key (id)
) engine=innodb comment '菜品口味表'