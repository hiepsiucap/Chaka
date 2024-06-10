/** @format */

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import "./App.css";
import { HomePage, RootLayout, Login, SignUp, Chat } from "./Page";
function App() {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <RootLayout></RootLayout>,
      children: [
        {
          path: "/",
          element: <HomePage></HomePage>,
        },
      ],
    },
    {
      path: "/login",
      element: <Login></Login>,
    },
    {
      path: "/signup",
      element: <SignUp></SignUp>,
    },
    {
      path: "/chat",
      element: <Chat></Chat>,
    },
  ]);
  return (
    <>
      <RouterProvider router={router} id="root" />
    </>
  );
}
export default App;
