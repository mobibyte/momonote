import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  base: '/',
  title: "MOMO Note",
  description: "shared study space",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
<<<<<<< HEAD
      { text: 'BIOL 1441', link: '/BIOL 1441/Syllabus.md' },
      { text: 'CSE 4308', link: '/CSE 4308/Syllabus.md' }
    ],

    // https://vitepress.dev/reference/default-theme-sidebar
    sidebar: {
      // This sidebar gets displayed when a user
      // is on `guide` directory.
      '/BIOL 1441/': [
        { text: 'Syllabus', link: '/BIOL 1441/Syllabus.md'},
        {
          text: 'Exam 1',
          collapsed: true,
          items: [
            { text: 'Lesson 1', link: '/BIOL 1441/Lesson 1.md' },
            { text: 'Lesson 2', link: '/BIOL 1441/Lesson 2.md' },
            { text: 'Lesson 3', link: '/BIOL 1441/Lesson 3.md' },
          ]
        },
        {
          text: 'Exam 2',
          collapsed: true,
          items: [
            { text: 'Lesson 4', link: '/BIOL 1441/Lesson 4.md' },
            { text: 'Lesson 5', link: '/BIOL 1441/Lesson 5.md' }
          ]
        }
      ],

      // This sidebar gets displayed when a user
      // is on `config` directory.
      '/CSE 4308/': [
        { text: 'Syllabus', link: '/CSE 4308/Syllabus.md'},
        {
          text: 'Quiz 1',
          items: [
            { text: 'Sample Quiz', link: '/CSE 4308/Quizzes/Quiz 1.md' },
          ]
        },
        {
          text: 'Quiz 2',
          items: [
            { text: 'Sample Quiz', link: '/CSE 4308/Quizzes/Quiz 2.md' },
          ]
        },
        {
          text: 'Quiz 3',
          items: [
            { text: 'Chapter 08', link: '/CSE 4308/Chapter 08.md' },
            { text: 'Chapter 11', link: '/CSE 4308/Chapter 11.md' },
            { text: 'Sample Quiz', link: '/CSE 4308/Quizzes/Quiz 3.md' },
          ]
        }
      ]
    },
=======
      { text: 'Biology', link: '/BIOL 1441/Syllabus.md' },
    ],

<<<<<<< HEAD
    sidebar: [
      {
        text: 'Biology',
        items: [
          { text: 'Syllabus', link: '/BIOL 1441/Syllabus.md' },
          { text: 'Lesson 1', link: '/BIOL 1441/Lesson 1.md' },
          { text: 'Lesson 2', link: '/BIOL 1441/Lesson 2.md' },
          { text: 'Lesson 3', link: '/BIOL 1441/Lesson 3.md' },
          { text: 'Lesson 4', link: '/BIOL 1441/Lesson 4.md' },
          { text: 'Lesson 5', link: '/BIOL 1441/Lesson 5.md' },
          { text: 'Exam 1', link: '/BIOL 1441/Exam 1.md' }
        ],
      },
      {
        text: 'Intermediate Programming',
        items: [
          { text: 'Syllabus', link: '/CSE 1320/Syllabus.md' },
          { text: 'Page 1', link: '/CSE 1320/page 1.md' },
          { text: 'Page 2', link: '/CSE 1320/page 2.md' },
          { text: 'Page 3', link: '/CSE 1320/page 3.md' },
          { text: 'Page 4', link: '/CSE 1320/page 4.md' },
          { text: 'Page 5', link: '/CSE 1320/page 5.md' },
          { text: 'Page 6', link: '/CSE 1320/page 6.md' },
        ],
      },
      {
        text: 'Object Oriented Programming',
        items: [
          { text: 'Syllabus', link: '/CSE 1325/Syllabus.md' },
          { text: 'Page 1', link: '/CSE 1325/page 1.md' },
          { text: 'Page 2', link: '/CSE 1325/page 2.md' },
          { text: 'Page 3', link: '/CSE 1325/page 3.md' },
          { text: 'Page 4', link: '/CSE 1325/page 4.md' },
          { text: 'Page 5', link: '/CSE 1325/page 5.md' },
          { text: 'Page 6', link: '/CSE 1325/page 6.md' },
        ],
      },
    ],
>>>>>>> 7c6f80d (feat: added 1320 notes page onto site (is visable))
=======
    sidebar: {
      // This sidebar gets displayed when a user
      // is on `guide` directory.
      '/BIOL 1441/': [
        { text: 'Syllabus', link: '/BIOL 1441/Syllabus.md'},
        {
          text: 'Exam 1',
          collapsed: true,
          items: [
            { text: 'Lesson 1', link: '/BIOL 1441/Lesson 1.md' },
            { text: 'Lesson 2', link: '/BIOL 1441/Lesson 2.md' },
            { text: 'Lesson 3', link: '/BIOL 1441/Lesson 3.md' },
          ]
        },
        {
          text: 'Exam 2',
          collapsed: true,
          items: [
            { text: 'Lesson 4', link: '/BIOL 1441/Lesson 4.md' },
            { text: 'Lesson 5', link: '/BIOL 1441/Lesson 5.md' }
          ]
        }
      ],

      // This sidebar gets displayed when a user
      // is on `config` directory.
      '/CSE 1320/': [
        {
          text: 'Intermediate Programming notes',
          items: [
            { text: 'Syllabus', link: '/CSE 1320/Syllabus.md' },
            { text: 'page 1', link: '/CSE 1320/page 1.md' },
            { text: 'page 2', link: '/CSE 1320/page 2.md' },
            { text: 'page 3', link: '/CSE 1320/page 3.md' },
            { text: 'page 4', link: '/CSE 1320/page 4.md' },
            { text: 'page 5', link: '/CSE 1320/page 5.md' },
            { text: 'page 6', link: '/CSE 1320/page 6.md' },
          ]
        }
      ],
      '/CSE 1325/': [
        {
          text: 'Sample Quizzes',
          items: [
            { text: 'Syllabus', link: '/CSE 1325/Syllabus.md' },
            { text: 'page 1', link: '/CSE 1325/page 1.md' },
            { text: 'page 2', link: '/CSE 1325/page 2.md' },
            { text: 'page 3', link: '/CSE 1325/page 3.md' },
            { text: 'page 4', link: '/CSE 1325/page 4.md' },
            { text: 'page 5', link: '/CSE 1325/page 5.md' },
            { text: 'page 6', link: '/CSE 1325/page 6.md' },
          ]
        }
      ],
      '/CSE 2313/': [
        {
          text: 'Sample Quizzes',
          items: [
            { text: 'Syllabus', link: '/CSE 2312/Syllabus.md' },
            { text: 'page 1', link: '/CSE 2312/page 1.md' },
            { text: 'page 2', link: '/CSE 2312/page 2.md' },
            { text: 'page 3', link: '/CSE 2312/page 3.md' },
            { text: 'page 4', link: '/CSE 2312/page 4.md' },
            { text: 'page 5', link: '/CSE 2312/page 5.md' },
            { text: 'page 6', link: '/CSE 2312/page 6.md' },
            { text: 'page 7', link: '/CSE 2312/page 7.md' },
          ]
        }
      ],
    },
>>>>>>> 119cd0a (Feat: added some of my 2312 notes)

    socialLinks: [
      { icon: 'github', link: 'https://github.com/mobiclub' }
    ]
  }
})
