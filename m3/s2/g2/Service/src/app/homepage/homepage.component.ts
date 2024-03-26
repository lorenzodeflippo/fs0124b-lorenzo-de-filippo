import { PostService } from './../post.service';
import { Component } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss'],
})
export class HomepageComponent {
  post!: PostInterface;
  related!: PostInterface[];


  constructor(private PostSvc:PostService) {
    this.post = this.PostSvc.getTopPost()
    this.related = this.PostSvc.getRandomPosts(4)
  }


}
