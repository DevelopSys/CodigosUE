import { Component, Input } from '@angular/core';
import { tarea } from '../../../model/tarea';
import { ImagenesPipe } from '../../../pipes/imagenes-pipe';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-card-item',
  imports: [ImagenesPipe, CommonModule, RouterLink],
  templateUrl: './card-item.html',
  styleUrl: './card-item.css',
})
export class CardItem {
  @Input() item?: tarea;
}
