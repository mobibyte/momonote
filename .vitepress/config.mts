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
        {
          text: 'Sample Quizzes',
          items: [
            { text: 'Quiz 1', link: '/CSE 4308/Quizzes/Quiz 1.md' },
            { text: 'Quiz 1', link: '/CSE 4308/Quizzes/Quiz 2.md' },
          ]
        }
      ]
    },

    socialLinks: [
      { icon: 'github', link: 'https://github.com/mobiclub' }
    ]
  }
})
