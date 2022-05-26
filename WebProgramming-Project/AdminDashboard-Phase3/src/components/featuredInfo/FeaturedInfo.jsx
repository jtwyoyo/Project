import "./featuredInfo.css";
import { ArrowDownward, ArrowUpward } from "@material-ui/icons";

export default function FeaturedInfo() {
  return (
    <div className="featured">
      <div className="featuredItem">
        <span className="featuredTitle">Website Visited</span>
        <div className="featuredMoneyContainer">
          <span className="featuredMoney">532 times</span>
          <span className="featuredMoneyRate">
            -11.4 <ArrowDownward  className="featuredIcon negative"/>
          </span>
        </div>
        <span className="featuredSub">Updated 1 week ago</span>
      </div>
      <div className="featuredItem">
        <span className="featuredTitle">Users Registered</span>
        <div className="featuredMoneyContainer">
          <span className="featuredMoney">10 Accounts</span>
          <span className="featuredMoneyRate">
            -1 <ArrowDownward className="featuredIcon negative"/>
          </span>
        </div>
        <span className="featuredSub">Updated 3 days ago</span>
      </div>
      <div className="featuredItem">
        <span className="featuredTitle">Movies Check</span>
        <div className="featuredMoneyContainer">
          <span className="featuredMoney">3 Movies needed update</span>
          <span className="featuredMoneyRate">
          </span>
        </div>
        <span className="featuredSub">Updated 3 weeks ago</span>
      </div>
    </div>
  );
}
