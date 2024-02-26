import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  base: '/',
  title: "MOMO Note",
  description: "college together",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
      { text: 'Biology', link: '/BIOL 1441/Syllabus.md' }
    ],

    sidebar: [
      {
        text: 'Biology',
        items: [
          { text: 'Syllabus', link: '/BIOL 1441/Syllabus.md' },
          { text: 'Lesson 1', link: '/BIOL 1441/Lesson 1.md' },
          { text: 'Lesson 2', link: '/BIOL 1441/Lesson 2.md' },
          { text: 'Lesson 3', link: '/BIOL 1441/Lesson 3.md' },
          { text: 'Exam 1', link: '/BIOL 1441/Exam 1.md' }
        ]
      }
    ],

    socialLinks: [
      { icon: 'github', link: 'https://github.com/mobiclub' }
    ]
  }
})
