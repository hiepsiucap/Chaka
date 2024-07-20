/** @format */
import { useState } from "react";
import logo from "../assets/logo.svg";
import { Link, useAsyncError } from "react-router-dom";
import { postRequest } from "../utilz/Request/Request";
import Swal from "sweetalert2/dist/sweetalert2.js";
import { useNavigate } from "react-router-dom";
const SignUp = () => {
  const navigate = useNavigate();
  const initial = {
    username: "",
    password: "",
    email: "",
    phoneNumber: "",
  };
  const [submitdata, ChangeData] = useState(initial);
  const onChangeData = (e) => {
    ChangeData((prev) => {
      return { ...prev, [e.target.id]: e.target.value };
    });
  };
  console.log(submitdata);
  const onSubmitHandler = async (e) => {
    e.preventDefault();
    const body = { ...submitdata };
    const data = await postRequest(
      "http://localhost:8080/api/auth/register",
      body
    );
    if (data.error) {
      Swal.fire({
        title: "Đăng kí thất bại",
        text: data.message,
        icon: "error",
      });
    } else {
      Swal.fire({
        title: "Đăng kí thành công",
        text: data.message,
        icon: "success",
      }).then((result) => {
        if (result.isConfirmed) {
          navigate("/login");
        }
      });
    }
  };

  return (
    <section className=" h-screen flex flex-col space-x-2 items-center justify-center ">
      <img src={logo} alt="" className=" w-32" />
      <div className=" text-3xl font-Roboto font-bold bg-gradient-to-r from-primary via-secondary to-background inline-block text-transparent bg-clip-text">
        Kết nối với những người bạn yêu quý.
      </div>
      <div className=" text-3xl font-Roboto font-bold bg-gradient-to-r pt-6 from-primary via-secondary to-background inline-block text-transparent bg-clip-text">
        Đăng kí tài khoản
      </div>
      <form
        className=" flex flex-col space-y-3 w-full items-center pt-6"
        onSubmit={onSubmitHandler}
      >
        <input
          type="text"
          className=" px-3 pr-12 py-2 border text-lg w-1/4 rounded-md border-gray-300 "
          placeholder="Email "
          id="email"
          onChange={onChangeData}
        />

        <input
          type="text"
          className=" px-3 pr-12 py-2 border text-lg w-1/4 rounded-md border-gray-300 "
          placeholder="số điện thoại"
          id="phoneNumber"
          onChange={onChangeData}
        />
        <input
          type="text"
          className=" px-3 pr-12 py-2 border text-lg w-1/4 rounded-md border-gray-300 "
          placeholder="Tên"
          id="username"
          onChange={onChangeData}
        />
        <input
          type="text"
          className=" px-3 pr-12 py-2 border text-lg w-1/4 rounded-md border-gray-300 "
          placeholder="Mật khẩu"
          id="password"
          onChange={onChangeData}
        />
        <div className=" pt-3"></div>
        <button className=" border bg-background px-6 py-3 rounded-full text-white font-bold  ">
          Đăng kí
        </button>
        <Link to="/login" className=" text-gray-500">
          Đã có tài khoản ?
        </Link>
      </form>
    </section>
  );
};
export default SignUp;
