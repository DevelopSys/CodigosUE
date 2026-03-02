import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(value: number, ...args: unknown[]): string {
    switch (value) {
      case 0:
        return 'https://www.shutterstock.com/image-vector/low-priority-rubber-grunge-stamp-260nw-2454126009.jpg';
      case 1:
        return 'https://www.shutterstock.com/image-vector/low-medium-high-priority-bar-260nw-2497478603.jpg';
      case 2:
        return 'https://t3.ftcdn.net/jpg/05/71/18/98/360_F_571189835_p0i50cg8woZ4H82pFmOdQrYFut7hqp52.jpg';
      default:
        return 'https://img.freepik.com/free-photo/priority-importance-tasks-urgency-effectivity-focus-concept_53876-125137.jpg?semt=ais_hybrid&w=740&q=80';
    }
  }
}
