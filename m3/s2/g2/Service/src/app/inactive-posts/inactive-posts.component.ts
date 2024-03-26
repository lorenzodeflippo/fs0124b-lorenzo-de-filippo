import { Component } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { PostService } from '../post.service';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent {
  posts!: PostInterface[];
  constructor(private postSvc:PostService) {
    this.posts = this.postSvc.getInactivePosts()
  }
}
