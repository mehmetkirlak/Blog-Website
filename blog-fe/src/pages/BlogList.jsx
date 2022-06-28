import React, { useState, useEffect } from "react";
import BlogService from "../services/blogService";
import {Button, Card, CardBody, CardGroup, CardSubtitle, CardText, CardTitle} from "reactstrap";
//{blogs.map((blog) =>())}

export default function BlogList(){
    const [blogs, setBlogs] = useState([])

    useEffect(() => {
        let blogService = new BlogService();
        blogService
            .getBlogs()
            .then((result) => setBlogs(result.data.data)).toString();
    }, []);

    return(
        <div>
            <CardGroup>
                {blogs.map((blog) =>(
                <Card>
                    <CardBody>
                        <CardTitle tag="h5">
                            {blog.title.toString()}
                        </CardTitle>
                        <CardText>
                            {blog.body.toString()}
                        </CardText>
                        <Button>
                            Read
                        </Button>
                    </CardBody>
                </Card>
                ))}
            </CardGroup>
        </div>
    )

}