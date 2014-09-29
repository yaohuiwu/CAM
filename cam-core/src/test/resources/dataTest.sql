insert into cam_role values
("r1","admin_org_1","org_id = '1'"),
("r2","admin_org_2","org_id = '2'"),
("r3","admin_org_3","org_id = '3'"),
("r4","admin_org_4","org_id = '4'"),
("r5","admin_org_5","org_id = '5'")
;

insert into cam_permission values
("p1","VIEW","com.pekall.mdm.Document","uploadBy = 'tom'"),
("p2","VIEW","com.pekall.mdm.Document","name like '%info'"),
("p3","VIEW","com.pekall.mdm.Document","uploadBy = 'tom'"),
("p4","VIEW","com.pekall.mdm.Document","uploadBy = 'tom'")
;

insert into cam_authorization (id,role_id,perm_id) values
("a_001","r1","p1"),
("a_002","r1","p2"),
("a_003","r2","p3")
;