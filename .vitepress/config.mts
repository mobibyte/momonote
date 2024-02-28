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
      { text: 'Biology', link: '/BIOL 1441/Syllabus.md' },
      { text: 'CSE 1320', link: '/CSE 1320/Syllabus.md' }
    ],

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
      }
    ],

    socialLinks: [
      { icon: 'github', link: 'https://github.com/mobiclub' }
    ]
  }
})
