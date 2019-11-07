--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)

-- Started on 2019-11-07 17:13:50 -03

CREATE TABLE public.gasto_mes (
    id integer NOT NULL,
    ano integer,
    instante_cadastro timestamp without time zone,
    instante_compra timestamp without time zone,
    mes integer,
    nome character varying(255),
    parcela integer,
    tipo_pagamento integer,
    total_parecela integer,
    valor double precision NOT NULL,
    tipogasto_id integer
);


ALTER TABLE public.gasto_mes OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16448)
-- Name: gasto_mes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gasto_mes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gasto_mes_id_seq OWNER TO postgres;

--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 196
-- Name: gasto_mes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gasto_mes_id_seq OWNED BY public.gasto_mes.id;


--
-- TOC entry 199 (class 1259 OID 16458)
-- Name: tipo_gasto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_gasto (
    id integer NOT NULL,
    nome character varying(40),
    obrigatorio boolean
);


ALTER TABLE public.tipo_gasto OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16456)
-- Name: tipo_gasto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_gasto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_gasto_id_seq OWNER TO postgres;

--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 198
-- Name: tipo_gasto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_gasto_id_seq OWNED BY public.tipo_gasto.id;


--
-- TOC entry 2796 (class 2604 OID 16453)
-- Name: gasto_mes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gasto_mes ALTER COLUMN id SET DEFAULT nextval('public.gasto_mes_id_seq'::regclass);


--
-- TOC entry 2797 (class 2604 OID 16461)
-- Name: tipo_gasto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_gasto ALTER COLUMN id SET DEFAULT nextval('public.tipo_gasto_id_seq'::regclass);


--
-- TOC entry 2925 (class 0 OID 16450)
-- Dependencies: 197
-- Data for Name: gasto_mes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.gasto_mes (id, ano, instante_cadastro, instante_compra, mes, nome, parcela, tipo_pagamento, total_parecela, valor, tipogasto_id) VALUES (1, 2018, '2019-11-07 17:53:25.189', '2018-12-20 10:32:00', 10, 'financiamento', 1, 2, 1, 1600, 1);
INSERT INTO public.gasto_mes (id, ano, instante_cadastro, instante_compra, mes, nome, parcela, tipo_pagamento, total_parecela, valor, tipogasto_id) VALUES (2, 2018, '2019-11-07 17:53:25.189', '2018-09-20 10:32:00', 10, 'condominio', 1, 2, 1, 400, 1);
INSERT INTO public.gasto_mes (id, ano, instante_cadastro, instante_compra, mes, nome, parcela, tipo_pagamento, total_parecela, valor, tipogasto_id) VALUES (3, 2018, '2019-11-07 17:53:25.189', '2018-09-20 10:32:00', 10, 'luz', 1, 1, 1, 200, 1);
INSERT INTO public.gasto_mes (id, ano, instante_cadastro, instante_compra, mes, nome, parcela, tipo_pagamento, total_parecela, valor, tipogasto_id) VALUES (4, 2018, '2019-11-07 17:53:25.189', '2018-09-20 10:32:00', 10, 'supermercado', 1, 2, 1, 400, 2);
INSERT INTO public.gasto_mes (id, ano, instante_cadastro, instante_compra, mes, nome, parcela, tipo_pagamento, total_parecela, valor, tipogasto_id) VALUES (5, 2018, '2019-11-07 17:53:25.189', '2018-09-20 10:32:00', 10, 'tenis', 1, 4, 3, 100, 3);
INSERT INTO public.gasto_mes (id, ano, instante_cadastro, instante_compra, mes, nome, parcela, tipo_pagamento, total_parecela, valor, tipogasto_id) VALUES (6, 2018, '2019-11-07 17:53:25.189', '2018-09-20 10:32:00', 11, 'tenis', 2, 4, 3, 100, 3);
INSERT INTO public.gasto_mes (id, ano, instante_cadastro, instante_compra, mes, nome, parcela, tipo_pagamento, total_parecela, valor, tipogasto_id) VALUES (7, 2018, '2019-11-07 17:53:25.189', '2018-09-20 10:32:00', 12, 'tenis', 3, 4, 3, 100, 3);


--
-- TOC entry 2927 (class 0 OID 16458)
-- Dependencies: 199
-- Data for Name: tipo_gasto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (1, 'casa1', true);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (2, 'alimentacao2', true);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (3, 'diversão3', false);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (4, 'casa4', true);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (5, 'alimentacao5', true);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (6, 'diversão6', false);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (7, 'casa7', true);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (8, 'alimentacao8', true);
INSERT INTO public.tipo_gasto (id, nome, obrigatorio) VALUES (9, 'diversão9', false);


--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 196
-- Name: gasto_mes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gasto_mes_id_seq', 7, true);


--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 198
-- Name: tipo_gasto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_gasto_id_seq', 9, true);


--
-- TOC entry 2799 (class 2606 OID 16455)
-- Name: gasto_mes gasto_mes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gasto_mes
    ADD CONSTRAINT gasto_mes_pkey PRIMARY KEY (id);


--
-- TOC entry 2801 (class 2606 OID 16463)
-- Name: tipo_gasto tipo_gasto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_gasto
    ADD CONSTRAINT tipo_gasto_pkey PRIMARY KEY (id);


--
-- TOC entry 2802 (class 2606 OID 16464)
-- Name: gasto_mes fkigrb81misfmgvv4gll6yrdr89; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gasto_mes
    ADD CONSTRAINT fkigrb81misfmgvv4gll6yrdr89 FOREIGN KEY (tipogasto_id) REFERENCES public.tipo_gasto(id);


-- Completed on 2019-11-07 17:13:50 -03

--
-- PostgreSQL database dump complete
--

