/**
 * @format
 * @type {import('tailwindcss').Config}
 */

module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      fontFamily: {
        Roboto: ["Roboto", "sans-serif"],
      },
      colors: {
        primary: "#38D7E7",
        primary2: "#F9F7F1",
        secondary: "#EE316B",
        background: "#842D72",
        button: "#04ABFF",
        // ...
      },
      backgroundImage: {
        "my-image":
          "url('https://res.cloudinary.com/dhhuv7n0h/image/upload/v1714202688/div.background_h76wu5.png')",
      },
    },
  },
  plugins: [],
};
