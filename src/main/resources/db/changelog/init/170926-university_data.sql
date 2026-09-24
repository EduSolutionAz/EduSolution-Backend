--liquibase formatted sql

--changeset ally:170926-university_data

INSERT INTO universities (
    country_id,
    university_name,
    university_type,
    description,
    university_logo_url,
    city
) VALUES
      (
          '0ba8ea26-6649-4b90-9fa9-a3633df3482d',
          'Budapest Metropolitan University',
          'PRIVATE',
          'Budapest Metropolitan University is a private university in Budapest, Hungary, offering practice-oriented programmes in business, communication, tourism, arts, and creative industries.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/budapest_metropolitan_university_logo.png',
          'Budapest'
      ),
      (
          '0315ff5a-9f7e-43b8-b0f8-d547bfbe6dcf',
          'Cyprus Science University',
          'PRIVATE',
          'Cyprus Science University is a private university established in 2013 in Kyrenia, Northern Cyprus, offering undergraduate and postgraduate programmes with a focus on practical and career-oriented education.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/cyprus-science-university-logo.png',
          'Kyrenia'
      ),
      (
          'ed2f9e45-3535-4a4a-80ee-ab3e47df2768',
          'Istanbul Medipol University',
          'PRIVATE',
          'Istanbul Medipol University is a private university established in 2009 in Istanbul, Türkiye, offering programmes across health sciences, medicine, engineering, business, law, and other fields.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/medipol_university_logo.png',
          'Istanbul'
      ),
      (
          'ed2f9e45-3535-4a4a-80ee-ab3e47df2768',
          'Istanbul Ozyegin University',
          'PRIVATE',
          'Özyeğin University is a private university in Istanbul, Türkiye, offering undergraduate and graduate programmes in business, engineering, architecture, law, social sciences, and other fields.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/ozyegin_logo.png',
          'Istanbul'
      ),
      (
          'ed2f9e45-3535-4a4a-80ee-ab3e47df2768',
          'TED University',
          'PRIVATE',
          'TED University is a private university in Ankara, Türkiye, offering English-taught programmes across engineering, education, business, economics, architecture, arts, and sciences.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/ted_university_logo.png',
          'Ankara'
      ),
      (
          '4a42640d-6884-4ffc-a09a-eccb28a227dc',
          'Vistula University',
          'PRIVATE',
          'Vistula University is a private university in Warsaw, Poland, offering Bachelor’s, Engineering, Master’s and postgraduate programmes in fields including business, finance, international relations, IT, architecture and more.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/vistula_university_logo.png',
          'Warsaw'
      ),
      (
          '4a42640d-6884-4ffc-a09a-eccb28a227dc',
          'Vizja University',
          'PRIVATE',
          'VIZJA University is a private university in Warsaw, Poland, offering programmes in psychology, management, computer science, finance, law, health sciences, and other fields.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/vizja_logo.png',
          'Warsaw'
      ),
      (
          '4a42640d-6884-4ffc-a09a-eccb28a227dc',
          'WSB University',
          'PRIVATE',
          'WSB University is a private university in Dąbrowa Górnicza, Poland, offering programmes in business, management, computer science, engineering, international relations, and other fields.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/wsb_logo.jpg',
          'Dąbrowa Górnicza'
      ),
      (
          '0315ff5a-9f7e-43b8-b0f8-d547bfbe6dcf',
          'World Peace University',
          'PRIVATE',
          'World Peace University is a private university in Nicosia, Northern Cyprus, offering programmes in business, engineering, architecture, law, psychology, health sciences, and other fields.',
          'https://pub-61dff26e8b8b473ab8b89d3b5b489917.r2.dev/university-bucket/world_peace_university_logo.png',
          'Nicosia'
      )