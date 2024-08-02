/** @format */

const EachChatRoom = ({ chatroom }) => {
  console.log(chatroom);
  if (chatroom.group)
    return (
      <button
        id={chatroom.roomId}
        className=" flex justify-between px-2 py-2 items-center"
      >
        <div className="flex space-x-3 items-center w-full">
          <div className="w-14 h-14 relative">
            <img
              src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
              alt=""
              className=" w-9 h-9 absolute rounded-full right-0 top-0"
            />
            <img
              src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
              alt=""
              className=" w-9 h-9 absolute rounded-full left-0 bottom-0"
            />
          </div>
          <div className=" flex flex-col font-medium space-y-0.5 justify-center">
            <p className="">{chatroom.roomName}</p>
            {chatroom.message && (
              <p className=" text-sm text-white scale-y-95">Chào bạn .15h</p>
            )}
          </div>
        </div>
        <div className="h-3 w-3 rounded-full bg-primary"></div>
      </button>
    );
};
//    <div className="flex space-x-3 px-2 py-2 bg-gray-800 rounded-lg">
//      <div className="">
//        <img
//          src="https://res.cloudinary.com/dhhuv7n0h/image/upload/v1710901348/rfb0bgnjivk8cujez1ft.jpg"
//          alt=""
//          className=" w-14 h-14 rounded-full"
//        />
//      </div>
//      <div className=" flex flex-col space-y-0.5 justify-center">
//        <p className="">Nguyễn Hồng Hiệp</p>
//        <p className=" text-sm text-stone-400 scale-y-95">Chào bạn .15h</p>
//      </div>
//    </div>;
export default EachChatRoom;
