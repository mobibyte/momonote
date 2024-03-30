import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  markdown: {
    math: true
  },
  lastUpdated: true,
  base: '/',
  title: "MOMO Note",
  description: "shared study space",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
      {
        text: 'CSE Notes',
        items: [
          { text: 'CSE 1320', link: '/CSE 1320/Syllabus.md' },
          { text: 'CSE 1325', link: '/CSE 1325/Syllabus.md' },
          { text: 'CSE 2312', link: '/CSE 2312/Syllabus.md' },
          { text: 'CSE 3318', link: '/CSE 3318/Syllabus.md' },
          { text: 'CSE 4308', link: '/CSE 4308/Syllabus.md' },
          { text: 'CSE 5382', link: '/CSE 5382/Syllabus.md' }
        ]
      },
      {
        text: 'BIOL Notes',
        items: [
          { text: 'BIOL 1441', link: '/BIOL 1441/Syllabus.md' },
        ]
      }
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
            { text: 'Lesson 1',
              collapsed: true,
              items: [
                { text: 'Learning Objectives', link: '/BIOL 1441/Lesson 01/Learning Objectives.md'},
                { text: 'Lecture Notes', link: '/BIOL 1441/Lesson 01/Lecture Notes.md'},
                { text: 'Lecture Exercises', link: '/BIOL 1441/Lesson 01/Lecture Exercises.md'},
                { text: 'Homework Answers', link: '/BIOL 1441/Lesson 01/Homework Answers.md'},
              ]
            },
            { text: 'Lesson 2',
              collapsed: true,
              items: [
                { text: 'Learning Objectives', link: '/BIOL 1441/Lesson 02/Learning Objectives.md'},
                { text: 'Lecture Notes', link: '/BIOL 1441/Lesson 02/Lecture Notes.md'},
                { text: 'Lecture Exercises', link: '/BIOL 1441/Lesson 02/Lecture Exercises.md'},
                { text: 'Homework Answers', link: '/BIOL 1441/Lesson 02/Homework Answers.md'},
              ]
            },
            { text: 'Lesson 3',
              collapsed: true,
              items: [
                { text: 'Learning Objectives', link: '/BIOL 1441/Lesson 03/Learning Objectives.md'},
                { text: 'Lecture Notes', link: '/BIOL 1441/Lesson 03/Lecture Notes.md'},
                { text: 'Lecture Exercises', link: '/BIOL 1441/Lesson 03/Lecture Exercises.md'},
                { text: 'Homework Answers', link: '/BIOL 1441/Lesson 03/Homework Answers.md'},
              ]
            },
          ]
        },
        {
          text: 'Exam 2',
          collapsed: true,
          items: [
            { text: 'Lesson 4',
              collapsed: true,
              items: [
                { text: 'Learning Objectives', link: '/BIOL 1441/Lesson 04/Learning Objectives.md'},
                { text: 'Lecture Notes', link: '/BIOL 1441/Lesson 04/Lecture Notes.md'},
                { text: 'Lecture Exercises', link: '/BIOL 1441/Lesson 04/Lecture Exercises.md'},
                { text: 'Homework Answers', link: '/BIOL 1441/Lesson 04/Homework Answers.md'},
              ]
            },
            { text: 'Lesson 5',
              collapsed: true,
              items: [
                { text: 'Learning Objectives', link: '/BIOL 1441/Lesson 05/Learning Objectives.md'},
                { text: 'Lecture Notes', link: '/BIOL 1441/Lesson 05/Lecture Notes.md'},
                { text: 'Lecture Exercises', link: '/BIOL 1441/Lesson 05/Lecture Exercises.md'},
                { text: 'Homework Answers', link: '/BIOL 1441/Lesson 05/Homework Answers.md'},
              ]
            },

          ]
        },
        {
          text: 'Exam 3',
          collapsed: true,
          items: [
            { text: 'Lesson 6',
              collapsed: true,
              items: [
                { text: 'Learning Objectives', link: '/BIOL 1441/Lesson 06/Learning Objectives.md'},
                { text: 'Lecture Notes', link: '/BIOL 1441/Lesson 06/Lecture Notes.md'},
                { text: 'Lecture Exercises', link: '/BIOL 1441/Lesson 06/Lecture Exercises.md'},
                { text: 'Homework Answers', link: '/BIOL 1441/Lesson 06/Homework Answers.md'},
              ]
            },
            { text: 'Lesson 7',
              collapsed: true,
              items: [
                { text: 'Learning Objectives', link: '/BIOL 1441/Lesson 07/Learning Objectives.md'},
                { text: 'Lecture Notes', link: '/BIOL 1441/Lesson 07/Lecture Notes.md'},
                { text: 'Lecture Exercises', link: '/BIOL 1441/Lesson 07/Lecture Exercises.md'},
                { text: 'Homework Answers', link: '/BIOL 1441/Lesson 07/Homework Answers.md'},
              ]
            },
          ]
        }
      ],

      '/CSE 1320/': [
        { text: 'Syllabus', link: '/CSE 1320/Syllabus.md'},
        {
          text: 'Exam 1',
          collapsed: true,
          items: [
            { text: 'Page 1', link: '/CSE 1320/page 1.md' },
            { text: 'Page 2', link: '/CSE 1320/page 2.md' },
            { text: 'Page 3', link: '/CSE 1320/page 3.md' },
            { text: 'Page 4', link: '/CSE 1320/page 4.md' },
            { text: 'Page 5', link: '/CSE 1320/page 5.md' },
            { text: 'Page 6', link: '/CSE 1320/page 6.md' },
          ]
        },
      ],

      '/CSE 1325/': [
        { text: 'Syllabus', link: '/CSE 1325/Syllabus.md'},
        {
          text: 'Midterm',
          collapsed: true,
          items: [
            { text: 'Page 1', link: '/CSE 1325/page 1.md' },
            { text: 'Page 2', link: '/CSE 1325/page 2.md' },
            { text: 'Page 3', link: '/CSE 1325/page 3.md' },
            { text: 'Page 4', link: '/CSE 1325/page 4.md' },
            { text: 'Page 5', link: '/CSE 1325/page 5.md' },
          ]
        },
        {
          text: 'Final',
          collapsed: true,
          items: [
            { text: 'Page 6', link: '/CSE 1325/page 6.md' },
          ]
        }
      ],

      '/CSE 2312/': [
        { text: 'Syllabus', link: '/CSE 2312/Syllabus.md'},
        {
          text: 'Exam 1',
          collapsed: true,
          items: [
            { text: 'Page 1', link: '/CSE 2312/page 1.md' },
            { text: 'Page 2', link: '/CSE 2312/page 2.md' },
            { text: 'Page 3', link: '/CSE 2312/page 3.md' },
            { text: 'Page 4', link: '/CSE 2312/page 4.md' },
            { text: 'Page 5', link: '/CSE 2312/page 5.md' },
            
          ]
        },
        {
          text: 'Exam 2',
          collapsed: true,
          items: [
            { text: 'Page 6', link: '/CSE 2312/page 6.md' },
            { text: 'Page 7', link: '/CSE 2312/page 7.md' },
            { text: 'Page 8', link: '/CSE 2312/page 8.md' },
            { text: 'Page 9', link: '/CSE 2312/page 9.md' },
          ]
        },
        {
          text: 'Final',
          collapsed: true,
          items: [
            { text: 'final note', link: '/CSE 2312/final.md'}
          ]
        }
      ],

      '/CSE 3318/': [
        { text: 'Syllabus', link: '/CSE 3318/Syllabus.md'},
        {
          text: 'Exam 1',
          collapsed: true,
          items: [
            { text: 'Stable, Insertion, Indirect Sort & Binary Search', link: '/CSE 3318/page 1.md' },
            { text: 'Time Complexity & Growth of Functions', link: '/CSE 3318/page 2.md' },
            
          ]
        },
        {
          text: 'Exam 2',
          collapsed: true,
          items: [
            { text: 'Priority Queue, Heap/Sort', link: '/CSE 3318/page 6.md' },
            { text: 'FIFO Queues & HashTables', link: '/CSE 3318/page 7.md' },
          ]
        },
        {
          text: 'Final',
          collapsed: true,
          items: [
          ]
        }
      ],

      // This sidebar gets displayed when a user
      // is on `config` directory.
      '/CSE 4308/': [
        { text: 'Syllabus', link: '/CSE 4308/Syllabus.md'},
        {
          text: 'Quiz 1',
          collapsed: true,
          items: [
            { text: 'Sample Quiz', link: '/CSE 4308/Quiz 1/Quiz 1.md' },
          ]
        },
        {
          text: 'Quiz 2',
          collapsed: true,
          items: [
            { text: 'Sample Quiz', link: '/CSE 4308/Quiz 2/Quiz 2.md' },
          ]
        },
        {
          text: 'Quiz 3',
          collapsed: true,
          items: [
            { text: 'Chapter 04', link: '/CSE 4308/Quiz 3/Chapter 04.md' },
            { text: 'Chapter 08', link: '/CSE 4308/Quiz 3/Chapter 08.md' },
            { text: 'Chapter 11', link: '/CSE 4308/Quiz 3/Chapter 11.md' },
            { 
              text: 'Sample Quiz', 
              items: [
                { text: 'Task 1', link: '/CSE 4308/Quiz 3/Task 1.md' },
                { text: 'Task 2', link: '/CSE 4308/Quiz 3/Task 2.md' },
                { text: 'Task 3', link: '/CSE 4308/Quiz 3/Task 3.md' },
                { text: 'Task 4', link: '/CSE 4308/Quiz 3/Task 4.md' },
                { text: 'Task 5', link: '/CSE 4308/Quiz 3/Task 5.md' },
                { text: 'Task 6', link: '/CSE 4308/Quiz 3/Task 6.md' },
                { text: 'Task 7', link: '/CSE 4308/Quiz 3/Task 7.md' },
                { text: 'Task 8', link: '/CSE 4308/Quiz 3/Task 8.md' },
              ]
            },
          ]
        }
      ],
      '/CSE 5382/': [
        { text: 'Syllabus', link: '/CSE 5382/Syllabus.md'},
        {
          text: 'Quiz 1',
          collapsed: true,
          items: [
            { text: 'Chapter 00', link: '/CSE 5382/Quiz 1/Chapter 00.md' },
            { text: 'Chapter 01', link: '/CSE 5382/Quiz 1/Chapter 01.md' },
            { text: 'Chapter 01', link: '/CSE 5382/Quiz 1/Chapter 01.md' },
            { text: 'Chapter 03', link: '/CSE 5382/Quiz 1/Chapter 03.md' },
            { text: 'Chapter 16', link: '/CSE 5382/Quiz 1/Chapter 16.md' },
            { text: 'Sample Quiz', link: '/CSE 5382/Quiz 1/Quiz 1.md' },
          ]
        },
        {
          text: 'Quiz 2',
          collapsed: true,
          items: [
            { text: 'Chapter 04',
              items: [
                { text: 'Lecture', link: '/CSE 5382/Quiz 2/Chapter 04 Lecture.md'},
                { text: 'Lab', link: '/CSE 5382/Quiz 2/Chapter 04 Lab.md'}
              ]
            },
            { text: 'Chapter 05', link: '/CSE 5382/Quiz 2/Chapter 05.md' },
            { text: 'Chapter 06', link: '/CSE 5382/Quiz 2/Chapter 06.md' },
            { text: 'Chapter 07', link: '/CSE 5382/Quiz 2/Chapter 07.md' },
            { text: 'Chapter 08', link: '/CSE 5382/Quiz 2/Chapter 08.md' },
            { text: 'Sample Quiz', link: '/CSE 5382/Quiz 2/Quiz 2.md' },
          ]
        },
        {
          text: 'Quiz 3',
          collapsed: true,
          items: [
            { text: 'Chapter 12', link: '/CSE 5382/Quiz 3/Chapter 12.md' },
            { text: 'Chapter 13', link: '/CSE 5382/Quiz 3/Chapter 13.md' },
            { text: 'Chapter 14', link: '/CSE 5382/Quiz 2/Chapter 14.md' },
            { text: 'Sample Quiz', link: '/CSE 5382/Quiz 3/Quiz 3.md' },
          ]
        }
      ]
    },

    socialLinks: [
      { icon: 'github', link: 'https://github.com/mobiclub' }
    ],

    search: 
    {
      provider: 'local'
    },

    editLink: {
      pattern: 'https://github.com/mobibyte/momonote'
    },
    
  }
})
