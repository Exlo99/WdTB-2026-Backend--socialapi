# Pytania inwestora · Biblioteka

Grupa 2 (CBm_2), zespół 4 · Repozytorium: 1NineTeen/WdTB-2026-Backend--biblioteka · Pakiet: `pl.wsb.biblioteka`

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
| P1 | 3 | BookRepository | Jakie książki dodał do katalogu pracownik o podanym adresie e-mail konta? Alfabetycznie według tytułu. | book, user_account |
| P2 | 3 | ReaderRepository | Którzy czytelnicy mają co najmniej jedno wypożyczenie o podanym statusie (np. ACTIVE)? Każdy czytelnik tylko raz. | reader, loan |
| P3 | 4 | LoanRepository | Ile wypożyczeń i ile łącznie przedłużeń ma każdy czytelnik? Wynik: imię i nazwisko czytelnika, liczba wypożyczeń, suma przedłużeń, od największej liczby wypożyczeń, a przy równej liczbie alfabetycznie według nazwiska. | loan, reader |

**Gdzie to piszecie.** Metoda w repozytorium, test w osobnej klasie, w tym samym pakiecie w `src/test/java`:

| Id | Metoda w | Test w |
|---|---|---|
| P1 | `src/main/java/pl/wsb/biblioteka/book/repository/BookRepository.java` | `src/test/java/pl/wsb/biblioteka/book/repository/P1BookRepositoryTest.java` |
| P2 | `src/main/java/pl/wsb/biblioteka/reader/repository/ReaderRepository.java` | `src/test/java/pl/wsb/biblioteka/reader/repository/P2ReaderRepositoryTest.java` |
| P3 | `src/main/java/pl/wsb/biblioteka/loan/repository/LoanRepository.java` | `src/test/java/pl/wsb/biblioteka/loan/repository/P3LoanRepositoryTest.java` |

**Podział pracy (rekomendacja).** Potrzebujecie co najmniej 4 repozytoriów (każde dla innej encji), w tym tych z tabeli, i trzech pytań.
Zalecamy podzielić to między siebie: każda osoba bierze jedno pytanie (razem z jego repozytorium) i robi je na własnej gałęzi `feature/…`
wychodzącej z `main`, potem Pull Request do `main`, który przegląda i scala inna osoba (instrukcja LAB 04, część B).
