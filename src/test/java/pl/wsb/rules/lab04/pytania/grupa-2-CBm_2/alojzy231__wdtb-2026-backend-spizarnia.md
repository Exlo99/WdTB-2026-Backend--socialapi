# Pytania inwestora · Spiżarnia

Grupa 2 (CBm_2), zespół 3 · Repozytorium: alojzy231/WdTB-2026-Backend-spizarnia · Pakiet: `pl.wsb.spizarnia`

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
| P1 | 3 | HouseholdMemberRepository | Kto należy do gospodarstwa domowego o podanej nazwie? Od osoby, która dołączyła najwcześniej. | household_member, household |
| P2 | 3 | HouseholdRepository | Które gospodarstwa domowe mają w spiżarni co najmniej jeden produkt, którego termin ważności upływa przed podaną datą? Każde gospodarstwo tylko raz. | household, pantry_item |
| P3 | 4 | ShoppingListItemRepository | Ile jeszcze niekupionych pozycji i za jaką szacowaną kwotę ma na liście zakupów każde gospodarstwo? Wynik: nazwa gospodarstwa, liczba pozycji, suma szacowanych cen, od największej sumy. | shopping_list_item, household |

**Gdzie to piszecie.** Metoda w repozytorium, test w osobnej klasie, w tym samym pakiecie w `src/test/java`:

| Id | Metoda w | Test w |
|---|---|---|
| P1 | `src/main/java/pl/wsb/spizarnia/household/repository/HouseholdMemberRepository.java` | `src/test/java/pl/wsb/spizarnia/household/repository/P1HouseholdMemberRepositoryTest.java` |
| P2 | `src/main/java/pl/wsb/spizarnia/household/repository/HouseholdRepository.java` | `src/test/java/pl/wsb/spizarnia/household/repository/P2HouseholdRepositoryTest.java` |
| P3 | `src/main/java/pl/wsb/spizarnia/shopping/repository/ShoppingListItemRepository.java` | `src/test/java/pl/wsb/spizarnia/shopping/repository/P3ShoppingListItemRepositoryTest.java` |

**Podział pracy (rekomendacja).** Potrzebujecie co najmniej 4 repozytoriów (każde dla innej encji), w tym tych z tabeli, i trzech pytań.
Zalecamy podzielić to między siebie: każda osoba bierze jedno pytanie (razem z jego repozytorium) i robi je na własnej gałęzi `feature/…`
wychodzącej z `main`, potem Pull Request do `main`, który przegląda i scala inna osoba (instrukcja LAB 04, część B).
