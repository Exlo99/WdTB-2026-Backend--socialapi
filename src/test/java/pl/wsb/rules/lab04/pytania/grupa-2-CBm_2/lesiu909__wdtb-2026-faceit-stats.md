# Pytania inwestora · FaceIT Stats

Grupa 2 (CBm_2), zespół 6 · Repozytorium: lesiu909/WdTB-2026-FaceIT-Stats · Pakiet: `pl.wsb.faceitstats`

Każde pytanie to jedna metoda w repozytorium z kolumny „Repozytorium” i jedna klasa testowa `@DataJpaTest` z testem `@DisplayName("P1 …")` (P2, P3).
**To są propozycje, nie obowiązek.** Pytania przygotowano na podstawie Waszego kodu i danych z `data.sql` (stan repozytorium z 28 listopada 2026).
Możecie je zrealizować albo ułożyć własne pytania o Wasze dane i wpisać ich treść w `@DisplayName` testu. W obu przypadkach ocenę wystawia
pipeline (przebieg „Testy i reguły”), więc każde pytanie musi spełnić jego kryteria:
- **P1:** metoda bez `@Query`, której warunek w nazwie zaczyna się od pola relacji encji repozytorium, np. `findByGuest_FullNameOrderByStartsAtDesc`;
- **P2:** metoda z `@Query` w JPQL z `join`, bez `group by`;
- **P3:** metoda z `@Query` z `group by`, zwracająca listę projekcji (interfejs z getterami), a nie encję.

Gdy w `data.sql` jest tylko jeden pasujący wiersz, a test ma sprawdzić kolejność albo grupowanie, dopiszcie dane w `src/test/resources/sql/p1.sql`
(`p2.sql`, `p3.sql`) i dodajcie `@Sql("/sql/p1.sql")` przy teście; `data.sql` zostaje bez zmian (instrukcja LAB 04, część C).
Rodzaje zapytań, gałęzie i kryteria oceny: instrukcja LAB 04.

| Id | Ocena | Repozytorium | Pytanie inwestora | Tabele |
|---|---|---|---|---|
| P1 | 3 | PlayerStatsRepository | Jakie wyniki indywidualne zanotowano w meczach rozegranych w podanym regionie serwera? Od największej liczby zabójstw. | player_stats, match_history |
| P2 | 3 | PlayerProfileRepository | Którzy gracze zdobyli w co najmniej jednym meczu co najmniej podaną liczbę zabójstw? Każdy gracz tylko raz. | player_profile, player_stats |
| P3 | 4 | PlayerStatsRepository | Na których mapach gracze radzą sobie najlepiej? Wynik: mapa, liczba zapisanych występów, średnia liczba zabójstw, od najwyższej średniej. | player_stats |

**Gdzie to piszecie.** Metoda w repozytorium, test w osobnej klasie, w tym samym pakiecie w `src/test/java`:

| Id | Metoda w | Test w |
|---|---|---|
| P1 | `src/main/java/pl/wsb/faceitstats/stats/repository/PlayerStatsRepository.java` | `src/test/java/pl/wsb/faceitstats/stats/repository/P1PlayerStatsRepositoryTest.java` |
| P2 | `src/main/java/pl/wsb/faceitstats/stats/repository/PlayerProfileRepository.java` | `src/test/java/pl/wsb/faceitstats/stats/repository/P2PlayerProfileRepositoryTest.java` |
| P3 | `src/main/java/pl/wsb/faceitstats/stats/repository/PlayerStatsRepository.java` | `src/test/java/pl/wsb/faceitstats/stats/repository/P3PlayerStatsRepositoryTest.java` |

**Podział pracy (rekomendacja).** Potrzebujecie co najmniej 4 repozytoriów (każde dla innej encji), w tym tych z tabeli, i trzech pytań.
Zalecamy podzielić to między siebie: każda osoba bierze jedno pytanie (razem z jego repozytorium) i robi je na własnej gałęzi `feature/…`
wychodzącej z `main`, potem Pull Request do `main`, który przegląda i scala inna osoba (instrukcja LAB 04, część B).
