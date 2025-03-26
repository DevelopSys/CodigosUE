import { Pipe, PipeTransform } from '@angular/core';
import { Post } from '../model/post';

@Pipe({
  name: 'imagenes',
  standalone: false,
})
export class ImagenesPipe implements PipeTransform {
  transform(value: string[], ...args: any[]): string {
    if (args[0] === 1) {
      if (value.includes('french')) {
        return 'https://media.istockphoto.com/id/1054778956/vector/french.jpg?s=612x612&w=0&k=20&c=9a1NhaM32UxzNEeskX7gzOWDxccSWJFbJSQmUcV52gs=';
      } else if (value.includes('fiction')) {
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4Y5QG3JDA6uLeK0k3iBPBGAGSu4XBJ7rpEQ&s';
      } else if (value.includes('history')) {
        return 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUfVuI-52gMsBUjICo8U71bZzPh_Sl60a0rw&s';
      } else if (value.includes('english')) {
        return 'https://media.istockphoto.com/id/1047570732/es/vector/ingl%C3%A9s.jpg?s=170667a&w=is&k=20&c=EUf63jOoahOmvYXjHbSUS8Mw764RKszkbFqPCTXg__E=';
      }
    } else {
      return 'https://images.squarespace-cdn.com/content/v1/57263bf8f8baf385ff61bb09/1535668320137-NZQPOXCGLFT34I9E4Z1E/Screen+Shot+2018-08-30+at+6.17.10+PM.png';
    }
    return 'https://images.squarespace-cdn.com/content/v1/57263bf8f8baf385ff61bb09/1535668320137-NZQPOXCGLFT34I9E4Z1E/Screen+Shot+2018-08-30+at+6.17.10+PM.png';
  }
}
