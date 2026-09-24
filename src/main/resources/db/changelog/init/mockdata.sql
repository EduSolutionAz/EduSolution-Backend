INSERT INTO countries (
    country_id,
    country_name,
    country_flag_url,
    country_photo_url,
    university_count,
    tuition_fee_entry,
    rental_fee_entry,
    visa_help,
    dormitory_help,
    created_at,
    updated_at
) VALUES
      (
          '11111111-1111-1111-1111-111111111111',
          'Poland',
          'https://example.com/flags/poland.png',
          'https://example.com/photos/poland.jpg',
          2,
          2500.00,
          500.00,
          true,
          true,
          CURRENT_TIMESTAMP,
          CURRENT_TIMESTAMP
      ),
      (
          '22222222-2222-2222-2222-222222222222',
          'Germany',
          'https://example.com/flags/germany.png',
          'https://example.com/photos/germany.jpg',
          1,
          0.00,
          700.00,
          true,
          false,
          CURRENT_TIMESTAMP,
          CURRENT_TIMESTAMP
      );

INSERT INTO universities (
    university_id,
    country_id,
    university_name,
    university_type,
    description,
    university_logo_url,
    city
) VALUES
      (
          'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          '11111111-1111-1111-1111-111111111111',
          'Vistula University',
          'PRIVATE',
          'A private university located in Warsaw, Poland.',
          'https://example.com/logos/vistula.png',
          'Warsaw'
      ),
      (
          'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
          '11111111-1111-1111-1111-111111111111',
          'University of Warsaw',
          'PUBLIC',
          'One of the largest and oldest universities in Poland.',
          'https://example.com/logos/uw.png',
          'Warsaw'
      ),
      (
          'cccccccc-cccc-cccc-cccc-cccccccccccc',
          '22222222-2222-2222-2222-222222222222',
          'Technical University of Munich',
          'PUBLIC',
          'A leading technical university in Germany.',
          'https://example.com/logos/tum.png',
          'Munich'
      );

INSERT INTO faculties (
    faculty_id,
    university_id,
    faculty_name
) VALUES
      (
          'aaaa1111-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'Faculty of Computer Engineering'
      ),
      (
          'aaaa2222-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'Faculty of Business'
      ),
      (
          'bbbb1111-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
          'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
          'Faculty of Computer Science'
      ),
      (
          'cccc1111-cccc-cccc-cccc-cccccccccccc',
          'cccccccc-cccc-cccc-cccc-cccccccccccc',
          'Department of Informatics'
      );

INSERT INTO programs (
    program_id,
    university_id,
    program_name,
    fee,
    semester_count
) VALUES
      (
          '10000000-0000-0000-0000-000000000001',
          'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'Computer Engineering',
          3200.00,
          7
      ),
      (
          '10000000-0000-0000-0000-000000000002',
          'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'International Business',
          2800.00,
          6
      ),
      (
          '20000000-0000-0000-0000-000000000001',
          'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
          'Computer Science',
          0.00,
          6
      ),
      (
          '30000000-0000-0000-0000-000000000001',
          'cccccccc-cccc-cccc-cccc-cccccccccccc',
          'Informatics',
          0.00,
          6
      );

INSERT INTO country_sections (
    section_id,
    country_id,
    title,
    content,
    areas
) VALUES
      (
          '50000000-0000-0000-0000-000000000001',
          '11111111-1111-1111-1111-111111111111',
          'Study in Poland',
          'Poland offers a wide range of study opportunities for international students.',
          'Education, Visa, Accommodation, Tuition'
      ),
      (
          '50000000-0000-0000-0000-000000000002',
          '22222222-2222-2222-2222-222222222222',
          'Study in Germany',
          'Germany is known for its strong public universities and technical education.',
          'Education, Visa, Accommodation, Tuition'
      );

INSERT INTO university_sections (
    section_id,
    university_id,
    faculty_id,
    title,
    content,
    areas
) VALUES
      (
          '60000000-0000-0000-0000-000000000001',
          'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'aaaa1111-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'Computer Engineering',
          'The Computer Engineering faculty provides practical and theoretical education in modern computing technologies.',
          'Programming, Software Engineering, Networks, Databases'
      ),
      (
          '60000000-0000-0000-0000-000000000002',
          'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'aaaa2222-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
          'Business Studies',
          'Students can develop business, management and entrepreneurship skills.',
          'Management, Finance, Marketing, Entrepreneurship'
      ),
      (
          '60000000-0000-0000-0000-000000000003',
          'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
          'bbbb1111-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
          'Computer Science',
          'The Computer Science faculty focuses on theoretical and practical aspects of computing.',
          'Algorithms, Programming, Artificial Intelligence'
      );