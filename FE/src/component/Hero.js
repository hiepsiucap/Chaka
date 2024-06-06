/** @format */
import HeroPic from "../assets/HeroPic.png";
const Hero = () => {
  return (
    <section className=" flex  px-6  space-x-12 justify-between items-center">
      <div className=" w-1/2 ">
        <p className=" text-7xl bg-gradient-to-r from-primary via-secondary to-background inline-block text-transparent bg-clip-text font-Roboto">
          Tụ họp <br></br> mọi lúc, mọi <br></br>nơi
        </p>
        <p className=" text-2xl pt-6 font-Roboto">
          Với Messenger, việc kết nối với những người thân yêu thật đơn giản và
          thú vị.
        </p>
        <form action="" className=" w-full flex flex-col space-y-3 pt-6 ">
          <input
            type="text"
            placeholder="Email hoặc số điện thoại"
            className=" font-Roboto px-3 py-2 bg-slate-100 text-Roboto text-lg border  w-2/3 rounded-lg"
          />
          <input
            type="text"
            placeholder="Mật khẩu"
            className=" font-Roboto px-3 py-2 bg-slate-100 text-Roboto text-lg border  w-2/3 rounded-lg"
          />
          <div className=" pt-2"></div>
          <div className=" flex space-x-5 items-center">
            <button className=" rounded-2xl border w-fit px-5 py-2 text-lg bg-background text-white font-bold font-Roboto bg-opacity-90">
              Đăng nhập
            </button>
            <p className=" text-background font-bold font-Roboto ">
              Chưa có tài khoản ?
            </p>
          </div>
        </form>
      </div>
      <div className=" w-1/2">
        <img src={HeroPic} alt="" />
      </div>
    </section>
  );
};
export default Hero;
