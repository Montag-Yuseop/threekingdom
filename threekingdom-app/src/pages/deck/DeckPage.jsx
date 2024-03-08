import SelectMenu from "@components/deck/SelectMenu";
import { Outlet } from "react-router-dom";

function DeckPage() {
  return (
    <div>
      <SelectMenu />
      <Outlet />
    </div>
  );
}

export default DeckPage;
