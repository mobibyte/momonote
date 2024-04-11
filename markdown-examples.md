# Markdown Extension Examples

This page demonstrates some of the built-in markdown extensions provided by VitePress.

VitePress provides Syntax Highlighting powered by [Shiki](https://github.com/shikijs/shiki), with additional features like line-highlighting:



## Custom Containers

**Input**

```md
::: info
This is an info box.
:::

::: tip
This is a tip.
:::

::: warning
This is a warning.
:::

::: danger
This is a dangerous warning.
:::

::: details
This is a details block.
:::
```

**Output**

::: info
This is an info box.
:::

::: tip
This is a tip.
:::

::: warning
This is a warning.
:::

::: danger
This is a dangerous warning.
:::

::: details
This is a details block.
:::

## Syntax Highlighting

VitePress provides Syntax Highlighting powered by [Shiki](https://github.com/shikijs/shiki), with additional features like line-highlighting:

**Input**

````md
```js{4}
export default {
  data () {
    return {
      msg: 'Highlighted!'
    }
  }
}
```
````

**Output**

```js{4}
export default {
  data () {
    return {
      msg: 'Highlighted!'
    }
  }
}
```

[See built-in languages here](https://shiki.style/languages)

## Math
To add math equations to your notes, wrap your text in dollar signs like this:

$P(Color \not= \frac{Green}{Vehicle=Truck})$

For a for list of supported math functions, click here: 
https://katex.org/docs/supported

## More

Check out the documentation for the [full list of markdown extensions](https://vitepress.dev/guide/markdown).
