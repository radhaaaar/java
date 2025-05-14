DROP TABLE IF EXISTS oe.order_details;
DROP TABLE IF EXISTS oe.orders;
DROP TABLE IF EXISTS oe.products;
DROP TABLE IF EXISTS oe.shippers;
DROP TABLE IF EXISTS oe.suppliers;
DROP TABLE IF EXISTS oe.categories;


--
-- Name: categories; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.categories (
    category_id smallint NOT NULL,
    category_name varchar(15) NOT NULL,
    description text,
    picture bytea,
	created_date  timestamp default current_timestamp,
    modified_date timestamp
);


--
-- Name: order_details; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.order_details (
    order_id smallint NOT NULL,
    product_id smallint NOT NULL,
    unit_price real NOT NULL,
    quantity smallint NOT NULL,
    discount real NOT NULL
);

--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.suppliers (
    supplier_id smallint NOT NULL,
    company_name varchar(40) NOT NULL,
	created_date  timestamp default current_timestamp,
    modified_date timestamp
);

CREATE TABLE oe.shippers (
    shipper_id smallint NOT NULL,
    company_name varchar(40) NOT NULL,
    phone varchar(24),
	created_date  timestamp default current_timestamp,
    modified_date timestamp,
    PRIMARY KEY (shipper_id)
);

--
-- Name: products; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE oe.products (
    product_id smallint NOT NULL,
    product_name varchar(40) NOT NULL,
    supplier_id smallint,
    category_id smallint,
    quantity_per_unit varchar(20),
    unit_price real,
    units_in_stock smallint,
    units_on_order smallint,
    reorder_level smallint,
    discontinued integer NOT NULL,
	created_date  timestamp default current_timestamp,
    modified_date timestamp
);


--
-- Name: orders; Type: TABLE; Schema: public; Owner: -; Tablespace: 
--

CREATE TABLE IF NOT EXISTS oe.orders
(
    order_id smallint NOT NULL,
    order_date date,
    required_date date,
    shipped_date date,
    ship_via smallint,
    freight real,
    ship_name varchar(40),
    total_discount decimal(5,2),
    total_amount decimal(8,2),
    payment_type varchar(15),
    transac_no varchar(25),
    transac_date timestamp without time zone,
    location_id integer,
    user_id integer,
    employee_id integer,
	created_date  timestamp default current_timestamp,
    modified_date timestamp,
    CONSTRAINT pk_orders PRIMARY KEY (order_id),
    CONSTRAINT fk_order_location FOREIGN KEY (location_id)
        REFERENCES hr.locations (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_orders_hr_employee FOREIGN KEY (employee_id)
        REFERENCES hr.employees (employee_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_orders_shippers FOREIGN KEY (ship_via)
        REFERENCES oe.shippers (shipper_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT orders_payment_type_check CHECK (payment_type::text = ANY (ARRAY['DEBIT'::varchar::text, 'CREDIT'::varchar::text, 'QRIS'::varchar::text, 'TRANSFER'::varchar::text]))
);


drop table if EXISTS fintech.transactions; 
drop table if EXISTS fintech.accounts;
drop table if EXISTS fintech.fintechs;


create table fintech.fintechs(
	fint_code varchar(3) constraint pk_fint_code primary key,
	fint_name varchar(125),
	fint_short_name varchar(15),
	fint_type varchar(10) check (fint_type in ('BANK','FINTECH','E-Wallet','P-GateAway')),
	created_date  timestamp default current_timestamp,
    modified_date timestamp
);
CREATE SEQUENCE IF NOT EXISTS person.users_user_id_seq INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS person.users
(
    user_id integer NOT NULL DEFAULT nextval('person.users_user_id_seq'::regclass),
    user_name character varying(15),
    user_email character varying(80),
    user_password character varying(125),
    user_handphone character varying(25),
    created_on timestamp without time zone,
    location_id integer,
    CONSTRAINT pk_user_id PRIMARY KEY (user_id),
    CONSTRAINT uq_user_email UNIQUE (user_email),
    CONSTRAINT uq_user_handphone UNIQUE (user_handphone),
    CONSTRAINT fk_user_locations FOREIGN KEY (location_id)
        REFERENCES hr.locations (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

create table fintech.accounts(
	account_id bigserial constraint pk_account_code primary key,
	account_no varchar(30) constraint uq_account_no unique,
	balance decimal(15,2),
	currency varchar(5),
	user_id integer constraint fk_accounts_users  references person.users(user_id),
	fin_code varchar(4) constraint fk_accounts_fintech  references fintech.fintechs(fint_code),
	created_date  timestamp default current_timestamp,
    modified_date timestamp
);

create table fintech.transactions(
	trac_id bigserial constraint pk_transactions primary key,
	trac_no varchar(25) constraint uq_transactions unique,
	from_account bigint 
		constraint fk_trac_from_account references fintech.accounts(account_id),
	to_account bigint 
		constraint fk_trac_to_account references fintech.accounts(account_id),
	trac_noref varchar(25) null
		constraint fk_trac_ref references fintech.transactions(trac_no),
	debet decimal(15,2),
	credit decimal(15,2),
	trac_type varchar(15) check (trac_type in ('TRANSFER','DEPOSIT','QRIS')),
	description varchar(55),
	created_date  timestamp default current_timestamp,
    modified_date timestamp,
    status varchar(20) check (status in ('PENDING','SUCCEES','FAILED','CANCELLED'))
);	





