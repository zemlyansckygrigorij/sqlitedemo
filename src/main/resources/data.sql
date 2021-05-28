DELETE FROM WELL;
DELETE FROM EQUIPMENT;
DELETE FROM WELL_EQUIPMENTS;
INSERT INTO WELL(name) values("Varun0");
INSERT INTO WELL(name) values("Varun1");
INSERT INTO WELL(name) values("Varun2");

INSERT INTO EQUIPMENT(name) values("eq0");
INSERT INTO EQUIPMENT(name) values("eq1");
INSERT INTO EQUIPMENT(name) values("eq2");

INSERT INTO WELL_EQUIPMENTS(well_id,equipments_id) values(1,1);
INSERT INTO WELL_EQUIPMENTS(well_id,equipments_id) values(2,2);
INSERT INTO WELL_EQUIPMENTS(well_id,equipments_id) values(3,3);

