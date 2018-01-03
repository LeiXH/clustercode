package net.chrigel.clustercode.transcode;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import net.chrigel.clustercode.transcode.messages.TranscodeBeginEvent;
import net.chrigel.clustercode.transcode.messages.TranscodeFinishedEvent;

public interface TranscodingService {

    /**
     * Performs the transcoding.
     *
     * @param task the cleanup, not null.
     */
    void transcode(TranscodeTask task);

    /**
     * Cancels the current transcoding job. Does nothing if no transcoding active.
     *
     * @return true if the job has been cancelled or none active. False if failed or cancellation timed out.
     */
    boolean cancelTranscode();

    Flowable<TranscodeBeginEvent> onTranscodeBegin();

    Flowable<TranscodeFinishedEvent> onTranscodeFinished();

    Observable<TranscodeProgress> onProgressUpdated();
}
