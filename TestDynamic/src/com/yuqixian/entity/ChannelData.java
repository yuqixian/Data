package com.yuqixian.entity;

import java.io.Serializable;

/**
 * 
 * ͨ��������
 * 
 * @author Administrator
 *
 */
public class ChannelData implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��Ա����
	 */
	private long timestamp; // ʱ���
	private int millisecond; //����
	private float speed; // ת��
	// PARAM ��
	private float gap; // ��϶��ѹ
	private float direct; // ͨƵֵ
	private float amplitude_1X; // 1��Ƶ��ֵ
	private float phase_1X; // 1��Ƶ��λ
	private float amplitude_2X; // ��ѡ��Ƶ��ֵ
	private float phase_2X; // ��ѡ��Ƶ��λ
	private float amplitude_3X; // ��ѡ��Ƶ��ֵ
	private float phase_3X; // ��ѡ��Ƶ��λ
	// WAVE ��
	private byte[] wave; 		// ѹ����Ĳ��ζ�ֵ̬
	private int waveLength;	// ѹ����ĳ���
	// SPECTRUM ��
	private byte[] spectrum;			// ѹ�����Ƶ�׶�ֵ̬
	private int spectrumLength;		// ѹ����ĳ���
	// �ɼ�����
	private int sampleRateOrder;	// �ױ���
	private float deltaOrder;			// �ױȷֱ���	
	
	/**
	 * ��Ա����
	 */
	public ChannelData() {
		timestamp = 0l;
		millisecond = 0;
		speed = 0.0f;
		gap = 0.0f;
		direct = 0.0f;
		amplitude_1X = 0.0f;
		phase_1X = 0.0f;
		amplitude_2X = 0.0f;
		phase_2X = 0.0f;
		amplitude_3X = 0.0f;
		phase_3X = 0.0f;
		wave = null;
		waveLength = 0;
		spectrum = null;
		spectrumLength = 0;
		sampleRateOrder = 0;
		deltaOrder = 0.0f;
	}

	/**
	 * ���ɱ�����get��set����
	 * 
	 * @return
	 */
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getMillisecond() {
		return millisecond;
	}

	public void setMillisecond(int millisecond) {
		this.millisecond = millisecond;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getGap() {
		return gap;
	}

	public void setGap(float gap) {
		this.gap = gap;
	}

	public float getDirect() {
		return direct;
	}

	public void setDirect(float direct) {
		this.direct = direct;
	}

	public float getAmplitude_1X() {
		return amplitude_1X;
	}

	public void setAmplitude_1X(float amplitude_1x) {
		amplitude_1X = amplitude_1x;
	}

	public float getPhase_1X() {
		return phase_1X;
	}

	public void setPhase_1X(float phase_1x) {
		phase_1X = phase_1x;
	}

	public float getAmplitude_2X() {
		return amplitude_2X;
	}

	public void setAmplitude_2X(float amplitude_2x) {
		amplitude_2X = amplitude_2x;
	}

	public float getPhase_2X() {
		return phase_2X;
	}

	public void setPhase_2X(float phase_2x) {
		phase_2X = phase_2x;
	}

	public float getAmplitude_3X() {
		return amplitude_3X;
	}

	public void setAmplitude_3X(float amplitude_3x) {
		amplitude_3X = amplitude_3x;
	}

	public float getPhase_3X() {
		return phase_3X;
	}

	public void setPhase_3X(float phase_3x) {
		phase_3X = phase_3x;
	}

	public byte[] getWave() {
		return wave;
	}

	public void setWave(byte[] wave) {
		this.wave = wave;
	}

	public int getWaveLength() {
		return waveLength;
	}

	public void setWaveLength(int waveLength) {
		this.waveLength = waveLength;
	}

	public byte[] getSpectrum() {
		return spectrum;
	}

	public void setSpectrum(byte[] spectrum) {
		this.spectrum = spectrum;
	}

	public int getSpectrumLength() {
		return spectrumLength;
	}

	public void setSpectrumLength(int spectrumLength) {
		this.spectrumLength = spectrumLength;
	}

	public int getSampleRateOrder() {
		return sampleRateOrder;
	}

	public void setSampleRateOrder(int sampleRateOrder) {
		this.sampleRateOrder = sampleRateOrder;
	}

	public float getDeltaOrder() {
		return deltaOrder;
	}

	public void setDeltaOrder(float deltaOrder) {
		this.deltaOrder = deltaOrder;
	}	
}
