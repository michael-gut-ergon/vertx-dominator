insert into CUSTOMER (NAME, HAS_ACTIVE_SERVICES, INSERTED, USERI) values ('MyCom', TRUE, now(), 'admin');
insert into CUSTOMER (NAME, HAS_ACTIVE_SERVICES, INSERTED, USERI) values ('FastNet', TRUE, now(), 'admin');
insert into CUSTOMER (NAME, HAS_ACTIVE_SERVICES, INSERTED, USERI) values ('BigWork', TRUE, now(), 'admin');

insert into FACTORY (NAME, FACTORY_TYPE, PARAMETER_TYPE, SERVER, PORT, CREATE_URL, CANCEL_URL, ACTIVATE_URL, SUSPEND_URL, UPDATE_URL, INSERTED, USERI) values ('PNM', 'INTERNAL', 'BODY.JSON', 'http://service.ch/pnm', 19110, 'GET:/rest/phone', 'DELETE:/rest/phone', null, null, null, now(), 'admin');
insert into FACTORY (NAME, FACTORY_TYPE, PARAMETER_TYPE, SERVER, PORT, CREATE_URL, CANCEL_URL, ACTIVATE_URL, SUSPEND_URL, UPDATE_URL, INSERTED, USERI) values ('DM', 'INTERNAL', 'BODY.JSON', 'http://service.ch/dn', 19180, 'GET:/rest/domain', 'DELETE:/rest/domain', null, null, null, now(), 'admin');
insert into FACTORY (NAME, FACTORY_TYPE, PARAMETER_TYPE, SERVER, PORT, CREATE_URL, CANCEL_URL, ACTIVATE_URL, SUSPEND_URL, UPDATE_URL, INSERTED, USERI) values ('INTERNET', 'EXTERNAL', 'BODY.JSON', 'http://service.ch/internet', 8080, 'GET:/api/internet', 'DELETE:/api/internet', null, null, null, now(), 'admin');
insert into FACTORY (NAME, FACTORY_TYPE, PARAMETER_TYPE, SERVER, PORT, CREATE_URL, CANCEL_URL, ACTIVATE_URL, SUSPEND_URL, UPDATE_URL, INSERTED, USERI) values ('IPTV', 'EXTERNAL', 'BODY.JSON', 'http://service.ch/iptv', 8080, 'GET:/api/tv', 'DELETE:/api/tv', null, null, null, now(), 'admin');

insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('Phone', uuid_generate_v4(), null, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('Internet', uuid_generate_v4(), null, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('IPTV', uuid_generate_v4(), null, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('Services', uuid_generate_v4(), null, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('Analog phone', uuid_generate_v4(), 1, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('VoIP', uuid_generate_v4(), 1, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('ADSL500', uuid_generate_v4(), 2, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('VDSL1000', uuid_generate_v4(), 2, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('VoIP1500', uuid_generate_v4(), 2, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('Fiber Starter', uuid_generate_v4(), 2, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('Fiber Top', uuid_generate_v4(), 2, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('MaxTV Basic', uuid_generate_v4(), 3, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('MaxTV Premium', uuid_generate_v4(), 3, '2016-10-01', null, now(), 'admin');
insert into PRODUCT (NAME, UUID, ROOT_PRODUCT, VALID_FROM, VALID_UNTIL, INSERTED, USERI) values ('Hosting', uuid_generate_v4(), 4, '2016-10-01', null, now(), 'admin');

insert into SERVICE_PRODUCTION (NAME, UUID, PRODUCT, FACTORY, INSERTED, USERI) values ('Phone Production', uuid_generate_v4(), 1, 1, now(), 'admin');
insert into SERVICE_PRODUCTION (NAME, UUID, PRODUCT, FACTORY, INSERTED, USERI) values ('Internet Production', uuid_generate_v4(), 2, 3, now(), 'admin');
insert into SERVICE_PRODUCTION (NAME, UUID, PRODUCT, FACTORY, INSERTED, USERI) values ('IPTV Production', uuid_generate_v4(), 3, 4, now(), 'admin');
insert into SERVICE_PRODUCTION (NAME, UUID, PRODUCT, FACTORY, INSERTED, USERI) values ('Hosting Production', uuid_generate_v4(), 14, 2, now(), 'admin');

insert into SERVICE_ORDER (NAME, UUID, CUSTOMER, PRODUCT, SERVICE_PARAMETER, STATE, INSERTED, USERI) values ('MyCom-Voip_Zürich', uuid_generate_v4(), 1, 6, null, 'CREATED', now(), 'admin');
insert into SERVICE_ORDER (NAME, UUID, CUSTOMER, PRODUCT, SERVICE_PARAMETER, STATE, INSERTED, USERI) values ('MyCom-TV_Bern', uuid_generate_v4(), 1, 12, null, 'CREATED', now(), 'admin');
insert into SERVICE_ORDER (NAME, UUID, CUSTOMER, PRODUCT, SERVICE_PARAMETER, STATE, INSERTED, USERI) values ('FastNet-Hosting', uuid_generate_v4(), 2, 14, 1, 'CREATED', now(), 'admin');
insert into SERVICE_ORDER (NAME, UUID, CUSTOMER, PRODUCT, SERVICE_PARAMETER, STATE, INSERTED, USERI) values ('BigWork-ADSL_3443', uuid_generate_v4(), 3, 7, 2, 'CREATED', now(), 'admin');
insert into SERVICE_ORDER (NAME, UUID, CUSTOMER, PRODUCT, SERVICE_PARAMETER, STATE, INSERTED, USERI) values ('BigWork-ADSL_3444', uuid_generate_v4(), 3, 7, null, 'CREATED', now(), 'admin');

insert into SERVICE_PARAMETER_BATCH (CREATED) values (now());
insert into SERVICE_PARAMETER_BATCH (CREATED) values (now());

insert into SERVICE_PARAMETER (SERVICE_PARAMETER_BATCH, NAME, PARAMETER_VALUE, PARAMETER_TYPE, UUID, INSERTED, USERI) values (1, 'Bandbreite Up', '500', 'int', uuid_generate_v4(), now(), 'admin');
insert into SERVICE_PARAMETER (SERVICE_PARAMETER_BATCH, NAME, PARAMETER_VALUE, PARAMETER_TYPE, UUID, INSERTED, USERI) values (1, 'Bandbreite Down', '250', 'int', uuid_generate_v4(), now(), 'admin');
insert into SERVICE_PARAMETER (SERVICE_PARAMETER_BATCH, NAME, PARAMETER_VALUE, PARAMETER_TYPE, UUID, INSERTED, USERI) values (1, 'Domain', 'myChocolate.ch', 'string', uuid_generate_v4(), now(), 'admin');
insert into SERVICE_PARAMETER (SERVICE_PARAMETER_BATCH, NAME, PARAMETER_VALUE, PARAMETER_TYPE, UUID, INSERTED, USERI) values (2, 'Directory entry', 'TRUE', 'boolean', uuid_generate_v4(), now(), 'admin');

insert into SERVICE (NAME, UUID, CUSTOMER, SERVICE_PARAMETER, VALID_FROM, STATE, INSERTED, USERI) values ('BigWork-ADSL500-3230', uuid_generate_v4(), 3, null, '2017-01-01', 'STARTED', now(), 'admin');
