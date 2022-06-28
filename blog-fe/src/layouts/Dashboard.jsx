import React from "react";
import BlogList from "../pages/BlogList";
import {Route, Routes} from "react-router-dom";
import Footer from "./Footer";

export default function Dashboard() {
    return (
        <div>
            <div className="row">
                <div className="col-9">
                    <BlogList/>
                </div>
                <div className="col-3">
                    categories
                </div>
            </div>
        </div>
    );
}