## Baza zajęć tanecznych

Baza zajęć tanecznych to aplikacja internetowa, która umożliwia użytkownikom rejestrację, 
oddawanie głosów na ulubione zajęcia taneczne oraz instruktorów tańca oraz komentowanie zajęć. 
Tylko administrator ma możliwość dodawania nowych treści na stronie.

## Technologie

Projekt został oparty o **Spring Boota 3** oraz **Javę 17**. 
W warstwie dostępu do danych wykorzystano **JPA, Hibernate i Spring Data**, 
a do migracji baz danych użyto **Liquibase**.

Utworzono dwa profile: developerski oraz produkcyjny, 
które różnią się wykorzystywanym silnikiem bazy danych i miejscem przechowywania uploadowanych plików.

Szatę graficzną aplikacji napisano z wykorzystaniem **Thymeleaf, HTML, trochę JavaScriptu i CSS**. 
Dzięki użyciu **Flexboxa** strona jest responsywna i dostosowana do wszystkich wielkości ekranu.

Całość łączy **Spring MVC**, a aplikację zabezpieczono z użyciem Spring Security. 
Konfiguracja opiera się o **Spring Boota**.