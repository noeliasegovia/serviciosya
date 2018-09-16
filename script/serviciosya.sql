PGDMP     5    /                v            serviciosya    10.5    10.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16621    serviciosya    DATABASE     �   CREATE DATABASE serviciosya WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Argentina.1252' LC_CTYPE = 'Spanish_Argentina.1252';
    DROP DATABASE serviciosya;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16656    city_seq    SEQUENCE     q   CREATE SEQUENCE public.city_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.city_seq;
       public       postgres    false    3            �            1259    16658    city    TABLE     �   CREATE TABLE public.city (
    id integer DEFAULT nextval('public.city_seq'::regclass) NOT NULL,
    name character varying(48) NOT NULL,
    province_id integer NOT NULL
);
    DROP TABLE public.city;
       public         postgres    false    202    3            �            1259    16635    country_seq    SEQUENCE     t   CREATE SEQUENCE public.country_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.country_seq;
       public       postgres    false    3            �            1259    16637    country    TABLE     �   CREATE TABLE public.country (
    id integer DEFAULT nextval('public.country_seq'::regclass) NOT NULL,
    name character varying(48) NOT NULL
);
    DROP TABLE public.country;
       public         postgres    false    198    3            �            1259    16622    occupation_seq    SEQUENCE     w   CREATE SEQUENCE public.occupation_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.occupation_seq;
       public       postgres    false    3            �            1259    16624 
   occupation    TABLE     �   CREATE TABLE public.occupation (
    id integer DEFAULT nextval('public.occupation_seq'::regclass) NOT NULL,
    name character varying(48) NOT NULL,
    description character varying(128) NOT NULL,
    parent integer
);
    DROP TABLE public.occupation;
       public         postgres    false    196    3            �            1259    16643    province_seq    SEQUENCE     u   CREATE SEQUENCE public.province_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.province_seq;
       public       postgres    false    3            �            1259    16645    province    TABLE     �   CREATE TABLE public.province (
    id integer DEFAULT nextval('public.province_seq'::regclass) NOT NULL,
    name character varying(48) NOT NULL,
    country_id integer NOT NULL
);
    DROP TABLE public.province;
       public         postgres    false    200    3                      0    16658    city 
   TABLE DATA               5   COPY public.city (id, name, province_id) FROM stdin;
    public       postgres    false    203   5                 0    16637    country 
   TABLE DATA               +   COPY public.country (id, name) FROM stdin;
    public       postgres    false    199   R       	          0    16624 
   occupation 
   TABLE DATA               C   COPY public.occupation (id, name, description, parent) FROM stdin;
    public       postgres    false    197   {                 0    16645    province 
   TABLE DATA               8   COPY public.province (id, name, country_id) FROM stdin;
    public       postgres    false    201   �                  0    0    city_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.city_seq', 1, false);
            public       postgres    false    202                       0    0    country_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.country_seq', 3, true);
            public       postgres    false    198                       0    0    occupation_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.occupation_seq', 1, false);
            public       postgres    false    196                       0    0    province_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.province_seq', 1, false);
            public       postgres    false    200            �
           2606    16663    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public         postgres    false    203            �
           2606    16642    country pk_country_id 
   CONSTRAINT     S   ALTER TABLE ONLY public.country
    ADD CONSTRAINT pk_country_id PRIMARY KEY (id);
 ?   ALTER TABLE ONLY public.country DROP CONSTRAINT pk_country_id;
       public         postgres    false    199            �
           2606    16629    occupation pk_occupation_id 
   CONSTRAINT     Y   ALTER TABLE ONLY public.occupation
    ADD CONSTRAINT pk_occupation_id PRIMARY KEY (id);
 E   ALTER TABLE ONLY public.occupation DROP CONSTRAINT pk_occupation_id;
       public         postgres    false    197            �
           2606    16650    province province_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.province
    ADD CONSTRAINT province_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.province DROP CONSTRAINT province_pkey;
       public         postgres    false    201            �
           2606    16664    city fk_city_province_id    FK CONSTRAINT     ~   ALTER TABLE ONLY public.city
    ADD CONSTRAINT fk_city_province_id FOREIGN KEY (province_id) REFERENCES public.province(id);
 B   ALTER TABLE ONLY public.city DROP CONSTRAINT fk_city_province_id;
       public       postgres    false    2697    201    203            �
           2606    16630 &   occupation fk_occupation_to_occupation    FK CONSTRAINT     �   ALTER TABLE ONLY public.occupation
    ADD CONSTRAINT fk_occupation_to_occupation FOREIGN KEY (parent) REFERENCES public.occupation(id);
 P   ALTER TABLE ONLY public.occupation DROP CONSTRAINT fk_occupation_to_occupation;
       public       postgres    false    2693    197    197            �
           2606    16651 "   province fk_province_to_country_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.province
    ADD CONSTRAINT fk_province_to_country_id FOREIGN KEY (country_id) REFERENCES public.country(id);
 L   ALTER TABLE ONLY public.province DROP CONSTRAINT fk_province_to_country_id;
       public       postgres    false    199    2695    201                  x������ � �            x�3�trw���s����� #��      	      x������ � �            x������ � �     