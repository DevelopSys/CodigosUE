import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../../services/data.service';
import { Post } from '../../model/post';

@Component({
  selector: 'app-detail',
  standalone: false,
  templateUrl: './detail.component.html',
  styleUrl: './detail.component.css',
})
export class DetailComponent {
  post: Post | undefined = undefined;

  constructor(
    private router: ActivatedRoute,
    private dataService: DataService
  ) {
    this.router.params.subscribe((params) => {
      this.dataService.getPostByIdURL(params['id']).subscribe((data) => {
        this.post = data;
      });
    });
  }
}
