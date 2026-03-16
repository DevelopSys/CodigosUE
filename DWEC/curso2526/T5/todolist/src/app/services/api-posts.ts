import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post, PostsReponse } from '../model/post';

@Injectable({
  providedIn: 'root',
})
export class ApiPosts {
  private url = 'https://dummyjson.com/post';

  constructor(private gestorHttp: HttpClient) {}

  getAllPost(): Observable<PostsReponse> {
    return this.gestorHttp.get<PostsReponse>(this.url);
  }

  getPostById(id: string): Observable<Post> {
    return this.gestorHttp.get<Post>(this.url + `/${id}`);
  }
}
