import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'imagenes',
})
export class ImagenesPipe implements PipeTransform {
  transform(value: string, ...args: any[]): unknown {
    if (value.length > 0) {
      return value;
    }

    return args[0];
  }
}
