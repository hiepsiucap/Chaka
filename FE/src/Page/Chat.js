/** @format */

const Chat = () => {
  const a = new Array(13);
  a.fill(1);
  console.log(a);
  return (
    <section className=" bg-bg1  p-5 text-white">
      <div className=" flex w-full space-x-3">
        <div className=" flex bg-bg2 rounded-xl flex-col h-screen  w-1/4 font-Roboto">
          <div className=" flex justify-between items-center px-3">
            <p className=" p-2 pt-4 font-bold text-2xl text-white">Tin nhắn</p>
            <button className=" px-2 py-2 bg-bg3 rounded-full">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#FFFFFF"
                class=" w-6"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M18 7.5v3m0 0v3m0-3h3m-3 0h-3m-2.25-4.125a3.375 3.375 0 1 1-6.75 0 3.375 3.375 0 0 1 6.75 0ZM3 19.235v-.11a6.375 6.375 0 0 1 12.75 0v.109A12.318 12.318 0 0 1 9.374 21c-2.331 0-4.512-.645-6.374-1.766Z"
                />
              </svg>
            </button>
          </div>
          <div className=" pl-5 pr-3 py-3">
            <div className=" flex space-x-2 px-3 py-2 bg-bg3 w-full rounded-full ">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="currentColor"
                class="size-5"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z"
                />
              </svg>

              <input
                type="text"
                className=" bg-opacity-0 bg-white w-full focus:outline-none focus:ring-0 border-0 border-opacity-0 focus:border-0 focus:border-opacity-0 w-full text-sm"
                placeholder="Tìm kiếm tin nhắn "
              />
            </div>
          </div>
          <div className="px-4 pt-4 h-screen overflow-auto  flex flex-col ">
            <div className=" flex justify-between px-2 py-2 items-center">
              <div className="flex space-x-3 items-center w-full">
                <div className="">
                  <img
                    src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
                    alt=""
                    className=" w-14 h-14 rounded-full"
                  />
                </div>
                <div className=" flex flex-col font-medium space-y-0.5 justify-center">
                  <p className="">Nguyễn Hồng Hiệp</p>
                  <p className=" text-sm text-white scale-y-95">
                    Chào bạn .15h
                  </p>
                </div>
              </div>
              <div className="h-3 w-3 rounded-full bg-primary"></div>
            </div>
            <div className="flex space-x-3 px-2 py-2 bg-gray-800 rounded-lg">
              <div className="">
                <img
                  src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
                  alt=""
                  className=" w-14 h-14 rounded-full"
                />
              </div>
              <div className=" flex flex-col space-y-0.5 justify-center">
                <p className="">Nguyễn Hồng Hiệp</p>
                <p className=" text-sm text-stone-400 scale-y-95">
                  Chào bạn .15h
                </p>
              </div>
            </div>
            {a.map(() => {
              return (
                <div className="flex space-x-3 px-2 py-2">
                  <div className="">
                    <img
                      src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
                      alt=""
                      className=" w-14 h-14 rounded-full"
                    />
                  </div>
                  <div className=" flex flex-col space-y-0.5 justify-center">
                    <p className="">Nguyễn Hồng Hiệp</p>
                    <p className=" text-sm text-stone-400 scale-y-95">
                      Chào bạn .15h
                    </p>
                  </div>
                </div>
              );
            })}
          </div>
        </div>
        <div className=" flex bg-bg2   flex-col rounded-xl h-screen w-2/4 font-Roboto">
          <div className=" flex py-3 px-3 justify-between items-center shadow-xl">
            <div className="flex space-x-2 items-center">
              <img
                src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
                alt=""
                className=" w-12 h-12 rounded-full"
              />
              <div>
                <div className=" font-medium">Nguyễn Hồng Hiệp</div>
                <div className=" text-sm text-stone-400">Active Now</div>
              </div>
            </div>
            <div className=" flex space-x-3">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="#38D7E7"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#38D7E7"
                class="size-5"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M2.25 6.75c0 8.284 6.716 15 15 15h2.25a2.25 2.25 0 0 0 2.25-2.25v-1.372c0-.516-.351-.966-.852-1.091l-4.423-1.106c-.44-.11-.902.055-1.173.417l-.97 1.293c-.282.376-.769.542-1.21.38a12.035 12.035 0 0 1-7.143-7.143c-.162-.441.004-.928.38-1.21l1.293-.97c.363-.271.527-.734.417-1.173L6.963 3.102a1.125 1.125 0 0 0-1.091-.852H4.5A2.25 2.25 0 0 0 2.25 4.5v2.25Z"
                />
              </svg>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="#38D7E7"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#38D7E7"
                class="size-5"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="m15.75 10.5 4.72-4.72a.75.75 0 0 1 1.28.53v11.38a.75.75 0 0 1-1.28.53l-4.72-4.72M4.5 18.75h9a2.25 2.25 0 0 0 2.25-2.25v-9a2.25 2.25 0 0 0-2.25-2.25h-9A2.25 2.25 0 0 0 2.25 7.5v9a2.25 2.25 0 0 0 2.25 2.25Z"
                />
              </svg>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#38D7E7"
                class="size-5"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="m11.25 11.25.041-.02a.75.75 0 0 1 1.063.852l-.708 2.836a.75.75 0 0 0 1.063.853l.041-.021M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Zm-9-3.75h.008v.008H12V8.25Z"
                />
              </svg>
            </div>
          </div>
          <div className=" flex flex-col space-y-1 mt-4 -mx-2 h-screen overflow-y-auto"></div>
          <div className="flex border-t-4 border-opacity-80 border-neutral-800 items-center  px-4 py-3 space-x-2">
            <div className=" flex space-x-2 items-center">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#38D7E7"
                class="size-6"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="m2.25 15.75 5.159-5.159a2.25 2.25 0 0 1 3.182 0l5.159 5.159m-1.5-1.5 1.409-1.409a2.25 2.25 0 0 1 3.182 0l2.909 2.909m-18 3.75h16.5a1.5 1.5 0 0 0 1.5-1.5V6a1.5 1.5 0 0 0-1.5-1.5H3.75A1.5 1.5 0 0 0 2.25 6v12a1.5 1.5 0 0 0 1.5 1.5Zm10.5-11.25h.008v.008h-.008V8.25Zm.375 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Z"
                />
              </svg>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#38D7E7"
                class="size-6"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M12.75 8.25v7.5m6-7.5h-3V12m0 0v3.75m0-3.75H18M9.75 9.348c-1.03-1.464-2.698-1.464-3.728 0-1.03 1.465-1.03 3.84 0 5.304 1.03 1.464 2.699 1.464 3.728 0V12h-1.5M4.5 19.5h15a2.25 2.25 0 0 0 2.25-2.25V6.75A2.25 2.25 0 0 0 19.5 4.5h-15a2.25 2.25 0 0 0-2.25 2.25v10.5A2.25 2.25 0 0 0 4.5 19.5Z"
                />
              </svg>
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#38D7E7"
                class="size-6"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M12 9v6m3-3H9m12 0a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z"
                />
              </svg>
            </div>
            <div className=" flex w-full space-x-2 px-3 py-2 bg-bg3 rounded-full ">
              <input
                type="text"
                className=" bg-opacity-0 focus:outline-none focus:ring-0 bg-white border-0 border-opacity-0 focus:border-0 focus:border-opacity-0 w-full text-sm"
                placeholder="Tìm kiếm tin nhắn "
              />
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="#38D7E7"
                class="size-6"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M15.182 15.182a4.5 4.5 0 0 1-6.364 0M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0ZM9.75 9.75c0 .414-.168.75-.375.75S9 10.164 9 9.75 9.168 9 9.375 9s.375.336.375.75Zm-.375 0h.008v.015h-.008V9.75Zm5.625 0c0 .414-.168.75-.375.75s-.375-.336-.375-.75.168-.75.375-.75.375.336.375.75Zm-.375 0h.008v.015h-.008V9.75Z"
                />
              </svg>
            </div>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="#38D7E7"
              class="size-6"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M6 12 3.269 3.125A59.769 59.769 0 0 1 21.485 12 59.768 59.768 0 0 1 3.27 20.875L5.999 12Zm0 0h7.5"
              />
            </svg>
          </div>
        </div>
        <div className=" flex bg-bg2 flex-col   rounded-xl h-screen w-1/4 font-Roboto">
          <div className="flex flex-col  py-12 px-5">
            <div className=" flex flex-col items-center">
              <img
                src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
                alt=""
                className=" w-20 h-20 rounded-full"
              />
            </div>
            <p className=" text-lg font-medium pt-3  flex flex-col items-center">
              Nguyễn Hồng Hiệp
            </p>
            <p className="text-sm text-stone-400  flex flex-col items-center">
              Active Now
            </p>
            <div className=" flex pt-6 justify-center space-x-5">
              <div className=" flex flex-col items-center space-y-2 ">
                <div className=" p-1.5 bg-bg3 rounded-full">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke-width="1.5"
                    stroke="currentColor"
                    class="size-6"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      d="M17.982 18.725A7.488 7.488 0 0 0 12 15.75a7.488 7.488 0 0 0-5.982 2.975m11.963 0a9 9 0 1 0-11.963 0m11.963 0A8.966 8.966 0 0 1 12 21a8.966 8.966 0 0 1-5.982-2.275M15 9.75a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"
                    />
                  </svg>
                </div>
                <p className=" text-sm text-gray-300">Profile</p>
              </div>
              <div className=" flex flex-col items-center space-y-2 ">
                <div className=" p-1.5 bg-bg3 rounded-full">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke-width="2"
                    stroke="currentColor"
                    class="size-6"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      d="M14.857 17.082a23.848 23.848 0 0 0 5.454-1.31A8.967 8.967 0 0 1 18 9.75V9A6 6 0 0 0 6 9v.75a8.967 8.967 0 0 1-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 0 1-5.714 0m5.714 0a3 3 0 1 1-5.714 0M3.124 7.5A8.969 8.969 0 0 1 5.292 3m13.416 0a8.969 8.969 0 0 1 2.168 4.5"
                    />
                  </svg>
                </div>
                <p className=" text-sm text-gray-300">Nofication</p>
              </div>
              <div className=" flex flex-col items-center space-y-2 ">
                <div className=" p-1.5 bg-bg3 rounded-full">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke-width="1.5"
                    stroke="currentColor"
                    class="size-6"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      d="m15.75 15.75-2.489-2.489m0 0a3.375 3.375 0 1 0-4.773-4.773 3.375 3.375 0 0 0 4.774 4.774ZM21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z"
                    />
                  </svg>
                </div>
                <p className=" text-sm text-gray-300">Search</p>
              </div>
            </div>
            <div className=" flex justify-between items-center pt-6">
              <p className=" pt-1 text-sm font-bold">Thông tin đoạn chat</p>
              <div>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke-width="2"
                  stroke="currentColor"
                  class="size-4"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    d="m19.5 8.25-7.5 7.5-7.5-7.5"
                  />
                </svg>
              </div>
            </div>
            <div className=" flex justify-between items-center pt-6">
              <p className=" pt-1 text-sm font-bold">File, đa phương tiện</p>
              <div>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke-width="2"
                  stroke="currentColor"
                  class="size-4"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    d="m19.5 8.25-7.5 7.5-7.5-7.5"
                  />
                </svg>
              </div>
            </div>
            <div className=" flex justify-between items-center pt-6">
              <p className=" pt-1 text-sm font-bold">Report</p>
              <div>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke-width="2"
                  stroke="currentColor"
                  class="size-4"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    d="m19.5 8.25-7.5 7.5-7.5-7.5"
                  />
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
export default Chat;
{
  /* <svg
  xmlns="http://www.w3.org/2000/svg"
  fill="none"
  viewBox="0 0 24 24"
  stroke-width="1.5"
  stroke="currentColor"
  class="size-6"
>
  <path
    stroke-linecap="round"
    stroke-linejoin="round"
    d="M9.143 17.082a24.248 24.248 0 0 0 3.844.148m-3.844-.148a23.856 23.856 0 0 1-5.455-1.31 8.964 8.964 0 0 0 2.3-5.542m3.155 6.852a3 3 0 0 0 5.667 1.97m1.965-2.277L21 21m-4.225-4.225a23.81 23.81 0 0 0 3.536-1.003A8.967 8.967 0 0 1 18 9.75V9A6 6 0 0 0 6.53 6.53m10.245 10.245L6.53 6.53M3 3l3.53 3.53"
  />
</svg>; */
}
