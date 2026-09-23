# Contact Manager (Aloqalar Boshqaruvchisi)

Bu loyiha **Spring Boot** va **Spring Security (JWT)** texnologiyalari yordamida yaratilgan RESTful API dasturi bo'lib, foydalanuvchilarga o'zlarining shaxsiy kontaktlarini xavfsiz boshqarish imkoniyatini beradi.

## 🛠 Texnologiyalar
* Java 17+
* Spring Boot
* Spring Security & JWT
* Spring Data JPA (Hibernate)
* PostgreSQL
* Lombok
* Maven

## ⚙️ O'rnatish va Ishga tushirish

1. **Ma'lumotlar bazasini yarating:**
   PostgreSQL-da `contact_manager_db` nomli baza oching.

2. **Sozlamalarni kiriting:**
   `src/main/resources/application.properties` faylini ochib, o'z ma'lumotlar bazasi parolingizni yozing:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/contact_manager_db
   spring.datasource.username=postgres
   spring.datasource.password=PAROLINGIZ
   
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   
   jwt.secret=maxfiykalitsozininguzunligimuhimvauniishonchliqlishkerak
   jwt.expiration=86400000
Loyihani ishga tushiring:
Terminalda quyidagi buyruqni bajaring yoki IDE orqali ContactManagerApplication'ni 🏃 Run qiling:

Bash

mvn spring-boot:run

🔌 Asosiy API Endpoints
👤 Auth & Profile
POST /api/auth/register – Ro'yxatdan o'tish

POST /api/auth/login – Tizimga kirish (JWT token olish)

GET /api/profile – Profil ma'lumotlarini ko'rish (Token talab qilinadi)

📞 Contacts
GET /api/contacts – Barcha kontaktlarni olish

POST /api/contacts – Yangi kontakt qo'shish

PUT /api/contacts/{id} – Kontaktni tahrirlash

DELETE /api/contacts/{id} – Kontaktni o'chirish
