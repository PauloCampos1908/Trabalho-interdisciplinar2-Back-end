--
-- PostgreSQL database dump
--

\restrict EDOxCZwgxL7bnWxdIlxisxRGUuQqxNdA5hwcAMXcWBf8HnfGKbKecGAJxWQdMrQ

-- Dumped from database version 17.6
-- Dumped by pg_dump version 17.6

-- Started on 2025-09-10 20:41:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16389)
-- Name: aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aluno (
    id integer NOT NULL,
    nome character varying NOT NULL,
    idade numeric NOT NULL,
    curso character varying
);


ALTER TABLE public.aluno OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16392)
-- Name: aluno_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aluno_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.aluno_id_seq OWNER TO postgres;

--
-- TOC entry 4796 (class 0 OID 0)
-- Dependencies: 218
-- Name: aluno_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aluno_id_seq OWNED BY public.aluno.id;


--
-- TOC entry 4641 (class 2604 OID 16393)
-- Name: aluno id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno ALTER COLUMN id SET DEFAULT nextval('public.aluno_id_seq'::regclass);


--
-- TOC entry 4789 (class 0 OID 16389)
-- Dependencies: 217
-- Data for Name: aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aluno (id, nome, idade, curso) FROM stdin;
\.


--
-- TOC entry 4797 (class 0 OID 0)
-- Dependencies: 218
-- Name: aluno_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aluno_id_seq', 1, false);


--
-- TOC entry 4643 (class 2606 OID 16400)
-- Name: aluno aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aluno
    ADD CONSTRAINT aluno_pkey PRIMARY KEY (id);


-- Completed on 2025-09-10 20:41:42

--
-- PostgreSQL database dump complete
--

\unrestrict EDOxCZwgxL7bnWxdIlxisxRGUuQqxNdA5hwcAMXcWBf8HnfGKbKecGAJxWQdMrQ

