import axios from "axios"

export default class BlogService{
    getBlogs(){
        return axios.get("http://localhost:8080/api/blogs")
    }
    getBlogById(id){
        return axios.get("http://localhost:8080/api/blogs/")
    }
}