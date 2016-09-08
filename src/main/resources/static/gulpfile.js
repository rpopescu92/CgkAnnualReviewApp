var gulp = require('gulp'),
    inject = require('gulp-inject'),
    bowerFiles = require('main-bower-files'),
    angularFileSort = require('gulp-angular-filesort');

gulp.task('inject:app', function () {
  var target = gulp.src('webapp/index.html');
  var customSources = gulp.src('webapp/app/**/*.js', {
                starttag: '<!-- inject:custom:{{ext}} -->',
                transform: function (filePath, file) {
                      // return file contents as string
                      return file.contents.toString('utf8')
                    }
            })
            .pipe(angularFileSort());

  return target
            .pipe(inject(customSources))
            .pipe(gulp.dest('webapp'));
});

gulp.task('inject:vendor', function(){
    var target = gulp.src('webapp/index.html');
     var sources = gulp.src(bowerFiles(), {read: false})
                    .pipe(inject(gulp.src('app/**/*.js')));


   return target
                .pipe(inject(sources))
                .pipe(gulp.dest('webapp'));
});

