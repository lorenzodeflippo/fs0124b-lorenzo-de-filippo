import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TodoComponent } from './components/todo/todo.component';
import { TodoallComponent } from './components/todoall/todoall.component';
import { TodonotComponent } from './components/todonot/todonot.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'todo',
    component: TodoComponent,
  },
  {
    path: 'todoall',
    component: TodoallComponent,
  },
  {
    path: 'todonot',
    component: TodonotComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
