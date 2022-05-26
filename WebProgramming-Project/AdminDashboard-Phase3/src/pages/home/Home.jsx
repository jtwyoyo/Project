import FeaturedInfo from "../../components/featuredInfo/FeaturedInfo";
import "./home.css";

export default function Home() {
  return (
    <div className="home">
      <div className="title">ADMIN DASHBOARD</div>
      <div className="widget">
        <FeaturedInfo></FeaturedInfo>
      </div>
    </div>
  );
}
