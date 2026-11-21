-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- Konta z LAB 01 są zachowane: reguła R1.03 wymaga co najmniej 3 kont poza kontami demo.

insert into user_account (email, display_name, role, created_at) values
                                                                     ('adrian.korycinski@student.wroclaw.merito.pl', 'Adrian', 'USER', current_timestamp),
                                                                     ('kontotest@student.merito.pl', 'Konto', 'USER', current_timestamp),
                                                                     ('ariel.jarosz@student.merito.wroclaw.pl', 'Ariel', 'USER', current_timestamp);

insert into user_profile
(username, display_name, email, bio, created_at,
 active, street, city, postal_code, user_account_id)
values
    ('alex_dev', 'Alex Johnson', 'alex@example.com',
     'Software development enthusiast',
     '2026-10-20 10:00:00', true,
     'Ruska 12', 'Wroclaw', '50-079', 1),

    ('maria_codes', 'Maria Smith', 'maria@example.com',
     'Sharing my daily life',
     '2026-10-21 12:30:00', true,
     'Swidnicka 3', 'Wroclaw', '50-066', 2),

    ('tom_travels', 'Tom Brown', 'tom@example.com',
     'Travel and photography',
     '2026-10-22 15:00:00', true,
     null, null, null, 3);

-- LAB 03
insert into hashtag (name, description, created_at, usage_count) values
                                                                     ('technology', 'Technology and innovation', current_timestamp, 1),
                                                                     ('programming', 'Programming and software development', current_timestamp, 2),
                                                                     ('travel', 'Travel and places', current_timestamp, 1);

-- LAB 02 / LAB 03
insert into social_post
(content, status, created_at, likes_count, comment_count, author_profile_id)
values
    ('Hello SocialAPI! My first post.',
     'PUBLISHED', '2026-10-22 09:00:00', 12, 3, 1),

    ('Working on a new project today.',
     'PUBLISHED', '2026-10-23 11:30:00', 7, 2, 2),

    ('My draft post for later.',
     'DRAFT', '2026-10-24 08:00:00', 0, 0, 3);

-- LAB 03
insert into reaction
(profile_id, post_id, type, created_at, active)
values
    (2, 1, 'LIKE', '2026-10-22 09:15:00', true),
    (3, 1, 'LOVE', '2026-10-22 09:20:00', true),
    (1, 2, 'LAUGH', '2026-10-23 12:00:00', true);

-- LAB 03
insert into post_comment
(content, created_at, edited_at, active, post_id, author_profile_id)
values
    ('Welcome to SocialAPI!', '2026-10-22 09:25:00', null, true, 1, 2),
    ('Looking forward to seeing more.', '2026-10-22 09:30:00', null, true, 1, 3),
    ('Good luck with the project!', '2026-10-23 12:15:00', null, true, 2, 1);

-- LAB 03

insert into social_post_hashtag (social_post_id, hashtag_id) values
                                                                 (1, 1),
                                                                 (1, 2),
                                                                 (2, 3);
