import { Component } from '@angular/core';
import { Post, PostsReponse } from '../../model/post';
import { ApiPosts } from '../../services/api-posts';

@Component({
  selector: 'app-post-fetch',
  imports: [],
  templateUrl: './post-fetch.html',
  styleUrl: './post-fetch.css',
})
export class PostFetch {
  posts: Post[] = [];
  constructor(private servicioPost: ApiPosts) {
    this.servicioPost.getAllPost().subscribe({
      next: (res: PostsReponse) => {
        this.posts = res.posts;
      },
      error: (err) => {
        /* Cuadro de dialogo de sweetalerts indicando que hay fallo */
      },
    });
  }
}
